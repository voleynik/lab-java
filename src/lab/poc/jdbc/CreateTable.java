package lab.poc.jdbc;
import java.sql.*;

public class CreateTable{

  public static void main(String[] args) {
    Connection dbCon = null;
    Statement stmt = null;
    try{
      dbCon = DriverManager.getConnection(Db.getUrl(), Db.getUserName(), Db.getUserPassword());
      if(dbCon != null){
        System.out.println("~ Connected to " + Db.getUrl());
      }
      stmt = dbCon.createStatement();
//      stmt.executeUpdate("create table T1( C1 int, C2 varchar(20), LastChangeTime datetime)"); // msSql
//      stmt.executeUpdate("create table T1( C1 INTEGER, C2 VARCHAR(20), LastChangeDate TIMESTAMP )"); //db2
      stmt.executeUpdate("create table T1( C1 INTEGER, C2 VARCHAR(20), LastChangeDateTime TIMESTAMP )");
      System.out.println("~ Table T1 created.");
    }catch(SQLException excpt){
      System.out.println("~ERROR: " + excpt.toString());
      excpt.printStackTrace(System.out);
    } finally {
      try{stmt.close();}catch(Exception ignore){}
      try{dbCon.close();}catch(Exception ignore){}
    }
    System.out.println("~~~~~~~~~~~ The END ~~~~~~~~~~~~~~~");
    //System.exit(0);
  }
}