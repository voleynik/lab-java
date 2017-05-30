package lab.jdbc;
import java.sql.*;

public class DbMetaData {
	public static String thisClass = "lab.jdbc.DbMetaData";
	public static void main(String[] args) {

		DatabaseMetaData dbmd = null;
		Connection dbCon = null;
		Statement stmt = null;
		ResultSet rSet = null;

		try {
			dbCon =
				DriverManager.getConnection(
					Db.getUrl(),
					Db.getUserName(),
					Db.getUserPassword());

			System.out.println( "dbCon: " + dbCon );
			
			System.out.println(
				"~TransactionIsolation: " + dbCon.getTransactionIsolation());

			dbmd = dbCon.getMetaData();
			System.out.println();
			System.out.println(
				"~DatabaseProductName: " + dbmd.getDatabaseProductName());
			System.out.println(
				"~DatabaseProductVersion: " + dbmd.getDatabaseProductVersion());
			System.out.println(
				"~DefaultTransactionIsolation: "
					+ dbmd.getDefaultTransactionIsolation());
			System.out.println("~DriverName: " + dbmd.getDriverName());
			System.out.println("~DriverVersion: " + dbmd.getDriverVersion());
			System.out.println("~URL: " + dbmd.getURL());
			System.out.println();

		} catch (SQLException excpt) {
			System.out.println( thisClass + " - ERROR: " + excpt.toString());
			System.out.println();
			System.out.println( "Driver: " + Db.getDriverName());
			System.out.println( "URL:    " + Db.getUrl());
			System.out.println( "Usr:    " + Db.getUserName());
			System.out.println( "Pwd:    " + Db.getUserPassword());

		} finally {
			try {
				dbCon.close();
			} catch (Exception ignore) {
			}
		}
		System.out.println("~~~~~~~~~~~ The END ~~~~~~~~~~~~~~~");
    //System.out.println("Current directory: " + System.getProperty("user.dir"));
		System.exit(0);
	}
}
/*
``
~DatabaseProductName: Microsoft SQL Server
~DatabaseProductVersion: Microsoft SQL Server  2000 - 8.00.760 (Intel X86) 
	Dec 17 2002 14:22:05 
	Copyright (c) 1988-2003 Microsoft Corporation
	Developer Edition on Windows NT 5.1 (Build 2600: Service Pack 2)
~TransactionIsolation: 2
~DefaultTransactionIsolation: 2
~DriverName: SQLServer
~DriverVersion: 2.2.0022

``
 */