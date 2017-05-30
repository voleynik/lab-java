package lab.stk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import lab.jdbc.Db;
public class RefreshAll {
	public static void main(String[] args) {
		double t1 = System.currentTimeMillis();
		lab.jdbc.Db.userDir = "K:/db";
		Connection dc = null;
	    Statement st = null;
	    ResultSet rs = null;
	    int ctr = 1;
	    try {
			dc = Db.getConnection();
			st = dc.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("select * from S order by S");
			PreparedStatement pst = dc.prepareStatement(StkSql.updRow);
			while(rs.next()){
				String s = rs.getString("S");
				//Stk stk = GetNyse.getStk(s);
				Stk stk  = GetYahoo.getStk(s);
				System.out.println(ctr++ + " " + s);
				if(stk != null){
					System.out.print(" " + stk.get_d() + "%");
					pst.setDouble(1, stk.get_d());
					pst.setObject(2, new Timestamp(System.currentTimeMillis()));
					pst.setObject(3, stk.get_s());
					pst.addBatch();
				}
			}
			pst.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{rs.close();}catch(Exception ignore){}
	      	try{st.close();}catch(Exception ignore){}
	      	try{dc.close();}catch(Exception ignore){}
	      	double t2 = System.currentTimeMillis();
	      	System.out.println("Time in min: " + (t2 - t1)/60000);
		}
	}
}
