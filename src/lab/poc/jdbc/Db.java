package lab.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Db {

	public static String userDir = System.getProperty("user.dir");

	//~Supported DB's
	private static final int ORACLE 	= 1;
	private static final int DERBY 		= 2;
	private static final int DB2APP 	= 3;
	private static final int DB2NET 	= 4;
	private static final int IDB    	= 5;
	private static final int MSSQL 		= 6;
	private static final int MYSQL 		= 7;
	private static final int POSTGRE 	= 8;

	//~Current DB.
	private static int dbName = POSTGRE;

	//~Load dirver class
	static {
		try {
			Class.forName(Db.getDriverName());
		} catch (ClassNotFoundException excpt) {
			System.err.println("APP_ERROR: Can't find class " + Db.getDriverName());
		}
	}

	//~Driver
	public static String getDriverName() {
		switch (dbName) {
			case 1:
				return "oracle.jdbc.driver.OracleDriver";
			case 2:
				//return "COM.cloudscape.core.JDBCDriver";
				//return "com.ihost.cs.jdbc.CloudscapeDriver";
				return "org.apache.derby.jdbc.EmbeddedDriver";
				//return "org.apache.derby.jdbc.ClientDriver";
			case 3:
				return "COM.ibm.db2.jdbc.app.DB2Driver";
			case 4:
				return "COM.ibm.db2.jdbc.net.DB2Driver";
			case 5:
				return "com.lutris.instantdb.jdbc.idbDriver";
			case 6:
				//return "com.newscale.jdbc.sqlserver.SQLServerDriver";
				return "com.newscale.jdbc.UnifiedDriver";
				//return "com.microsoft.jdbc.sqlserver.SQLServerDriver";
			case 7:
				return "org.gjt.mm.mysql.Driver";
			case 8:
				return "org.postgresql.Driver";
			default:
				return null;
		}
	}

	//~DbURL
	public static String getUrl() {
		switch (dbName) {
		case 1:
			return "jdbc:oracle:thin:@db.verient.com:1521:dev1";
		case 2:
			//return "jdbc:derby://localhost:1527/DERBY-DATA;create=true";
			return "jdbc:derby:" + "I:\\a1\\DERBY-DATA;create=true";
			//return "jdbc:derby:" + userDir + "/../../../derby/data;create=true"; // ...\a1\derby\data OK
			//return "jdbc:cloudscape:D:/apps/cloudscape/cloudscape-data;create=true";
			//return "jdbc:cloudscape:C:/APPS/Cloudscape10/demo/databases/vo;create=true";
			//return "jdbc:cloudscape:G:/a1/projects-a1/lab/labUtil/voDb;create=true";	
		case 3:
			return "jdbc:db2:CSIHUB";
		case 4:
			return "jdbc:db2:host_name:5000/SAMPLE";
		case 5:
			return "jdbc:idb:C:/apps/idb/Examples/sample.prp";
		case 6:
			//return "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=RequestCenter";
			return "jdbc:newscale:sqlserver://localhost:1433;DatabaseName=RequestCenter";
		case 7:
			return "jdbc:mysql://localhost:3306/test";
		case 8:
			return "jdbc:postgresql://localhost:5432/postgres";
		default:
			return null;
		}
	}

	//~DbUserName
	public static String getUserName() {
		switch (dbName) {
		case 1:
			return "be";
		case 2:
			return "";
		case 3:
			return "db2admin";
		case 4:
			return "Administrator";
		case 5:
			return "";
		case 6:
			return "RCUser";
		case 7:
			return "root";
		case 8:
			return "postgres";
		default:
			return null;
		}
	}

	//~DbUserPassword
	public static String getUserPassword() {
		switch (dbName) {
		case 1:
			return "veri";
		case 2:
			return "";
		case 3:
			return "db2admin";
		case 4:
			return "vo";
		case 5:
			return "";
		case 6:
			return "RC";
		case 7:
			return "";
		case 8:
			return "postgres";
		default:
			return null;
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		Connection dbCon = null;
		try {
			dbCon = DriverManager.getConnection(getUrl(), getUserName(), getUserPassword());
		} catch (SQLException excpt) {
			System.err.println(excpt.toString());
			System.err.println("Can't connect to URL " + getUrl());
			throw excpt;
		}
		return dbCon;
	}
}