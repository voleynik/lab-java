package lab.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

//import org.apache.derby.jdbc.ClientConnectionPoolDataSource;

public class DbConnector {

	public static Connection getConnection(String dbUrl, String host, int port){
//		ClientConnectionPoolDataSource cpds = new ClientConnectionPoolDataSource();
		
//		cpds.setDatabaseName("E:\\a1\\DERBY-DATA");
//		cpds.setServerName("localhost");
//		cpds.setPortNumber(1527);
		
//		cpds.setDatabaseName( dbUrl );
//		cpds.setServerName( host );
//		cpds.setPortNumber( port );
//		
//		try {
//			
//			Connection dbCon = cpds.getConnection();
//			//Connection dbCon = cpds.getConnection("vo", "vo1"); // no good
//			
//			System.out.println("dbCon: " + dbCon);
//			
//			return dbCon;
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
        return null;
	}
}
