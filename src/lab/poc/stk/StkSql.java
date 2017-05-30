package lab.poc.stk;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;

import lab.poc.jdbc.Db;
import lab.poc.jdbc.SqlRunner;
import lab.poc.util.Lgr;

public class StkSql {
	public static final String tbl = "S";
	public static final String updRow = "update " + tbl + " set D = ?, T = ? where S = ?";
	private static final String addRow = "insert into " + tbl + " values(?, null, ?)";
	
	public static int updateRow(String s, Double d, Timestamp t){
		Object[] parms = new Object[3];
			parms[0] = d;
			parms[1] = t;
			parms[2] = s;
			try {
				return SqlRunner.runUpdate(updRow, parms);
			} catch (Exception e) {
				Lgr.log(e, "APP-ERR failed to update row.");
				System.err.println(e.getMessage());
			}
		return 0;
	}
	
	public static int addAll(Object[] stkArray){
		Object[] parms = new Object[2];
		for(int i = 0; i < stkArray.length; i++){
			parms[0] = stkArray[i];
			parms[1] = new Timestamp(System.currentTimeMillis());
			try {
				SqlRunner.runUpdate(addRow, parms);
			} catch (Exception e) {
				Lgr.log(e, "APP-ERR failed to add " + stkArray[i]);
				System.err.println(e.getMessage());
			}
		}
		return 0;
	}
	
	public static int add(Object[] stkArray) throws Exception {
		int addRows = 0;
		Connection dbCon = null;
	    Statement stm = null;
	    
	    try{
	    	dbCon = Db.getConnection();
			stm = dbCon.createStatement();

	      	//~ Set sql parms represented by ?.
	      	for(int i = 0; i < stkArray.length; i++){
	      		try{
	      			addRows = addRows + stm.executeUpdate("insert into " + tbl + " (S) values('" + stkArray[i] + "')");
	      		}catch(Exception ignore){
	      		}
	      	} 	
	    }finally{
	      	try{stm.close();}catch(Exception ignore){}
	      	try{dbCon.close();}catch(Exception ignore){}
		}
	    return addRows;
	}
	
	public static int[] addBatch(Object[] stkArray) throws Exception {
		int[] counters = new int[stkArray.length];
		Connection dbCon = null;
	    Statement stm = null;
	    
	    try{
	    	dbCon = Db.getConnection();
			stm = dbCon.createStatement();

	      	//~ Set sql parms represented by ?.
	      	for(int i = 0; i < stkArray.length; i++){
	      		stm.addBatch("insert into " + tbl + " (S) values('" 
	      				+ stkArray[i] + "')");
	      	}
	      	
	      	return stm.executeBatch();
	      	
	    }finally{
	      	try{stm.close();}catch(Exception ignore){}
	      	try{dbCon.close();}catch(Exception ignore){}
		}
	}
}
