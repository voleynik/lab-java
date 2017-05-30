package lab.jdbc;
import java.sql.*;

public class DbDataTypes {

	public static void main(String[] parms) {
//		System.out.println("curDir: " + Db.userDir);
//		System.out.println("Url: " + Db.getUrl());
		Connection dbCon = null;
		try {
			dbCon =
				DriverManager.getConnection(
					Db.getUrl(),
					Db.getUserName(),
					Db.getUserPassword());
			
//			dbCon = DbConnector.getConnection("E:\\a1\\DERBY-DATA", "localhost", 1527 );
			
			System.out.println();
			System.out.println("~~ dbCon = " + dbCon);
			DatabaseMetaData dbmd = dbCon.getMetaData();
			System.out.println(
				"~~ JDBC driver version: " + dbmd.getDriverVersion());

			//~Print all supported data types.
			ResultSet rs = dbmd.getTypeInfo();
			System.out.println();
			System.out.println("~~ All supported data types:");
			int ctr = 1;
			while (rs.next()) {
				System.out.print(
					ctr + ". Type name = " + rs.getString("TYPE_NAME"));
				System.out.print("   Data type = " + rs.getString("DATA_TYPE"));
				System.out.print("   Precision = " + rs.getString("PRECISION"));
				System.out.print(
					"   Min scale = " + rs.getString("MINIMUM_SCALE"));
				System.out.print(
					"   Max scale = " + rs.getString("MAXIMUM_SCALE"));
				System.out.println(
					"   SQL Type = " + rs.getString("SQL_DATA_TYPE"));
				ctr++;
			}

			//~More info...
			

		} catch (SQLException excpt) {
			System.out.println("~ SQL problem:");
			excpt.printStackTrace(System.out);
		} finally {
			try {
				dbCon.close();
			} catch (Exception ignore) {
			}
		}
	}
}