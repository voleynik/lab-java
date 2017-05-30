package lab.poc.stk;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
	private static final String curDir = System.getProperty("user.dir");
	private static final String d = "com.ihost.cs.jdbc.CloudscapeDriver";
	private static final String u = "jdbc:cloudscape:" + curDir + "\\voDb;create=true";
	private static final String t1 = "S";
	private static final String singleShare1 = "http://www.singleshare.com/lists/completelist";
	private static final String singleShare2 = ".shtml";
	private static String msg = "";
	private static DatabaseMetaData md = null;
	private static Connection dc = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	public static void main(String[] args){
		try {
			
			
			
			
			
		} catch (Exception e) {
			System.err.println(msg + " . . . FAILED");
			System.exit(1);
		}finally{
			try{rs.close();}catch(Exception e){}
			try{st.close();}catch(Exception e){}
			try{dc.close();}catch(Exception e){}
			System.exit(0);
		}
	}
	private void loadData(){
		
	}
	private static void createTable(String t) throws Exception {
		st = dc.createStatement();
		msg = "Create table " + t;
		st.executeUpdate("create table " + t1 + " ( stk VARCHAR(50), dwn DECIMAL(3,2), ts TIMESTAMP )");
	}
	private static boolean tableExists(String t) throws Exception {
		msg = "Get list of tables";
		rs = md.getTables( null, null, null, new String[]{"TABLE"} );
		msg = "Check the table";
		while(rs.next()){
			if(rs.getString("TABLE_NAME").equalsIgnoreCase(t)){
				return true;
			} 
        }
		return false;
	}
	static {
		try { 
			msg = "Find class for " + d;
			Class.forName(d);
			msg = "Get connection using \n" + d + " AND " + u;
			dc = DriverManager.getConnection(u, "", "");
			msg = "Get metadata";
			md = dc.getMetaData();
			if(!tableExists(t1)) createTable(t1);
		} catch (Exception excpt) {
			System.err.println(msg + " . . . FAILED");
			System.exit(0);
		}
		
	}
}
