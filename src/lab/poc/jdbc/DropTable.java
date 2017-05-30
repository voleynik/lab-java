package lab.poc.jdbc;
import java.sql.*;

public class DropTable{

  public static void main(String[] args) {
    Connection dbCon = null;
    Statement stmt = null;
    try{
      //dbCon = DriverManager.getConnection(Db.getUrl(), Db.getUserName(), Db.getUserPassword());
      dbCon = DbConnector.getConnection("E:\\a1\\DERBY-DATA", "localhost", 1527 );

      if(dbCon != null){
        //System.out.println("~ connected to " + Db.getUrl());
        System.out.println("~ dbCon: " + dbCon );
      }
      stmt = dbCon.createStatement();
      stmt.executeUpdate("drop table T1");
      System.out.println("~Table dropped.");
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
