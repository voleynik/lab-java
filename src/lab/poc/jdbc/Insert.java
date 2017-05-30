package lab.poc.jdbc;
import java.sql.*;

public class Insert{

  public static void main(String[] args) throws InterruptedException{
    Connection dbCon = null;
    PreparedStatement pStm = null;
    try{
//      String sqlString = "insert into T1 (C1, C2, LastChangeDate, LastChangeTime) values(?, ?, ?, ?)"; //mysql
//      String sqlString = "insert into T1 (C1, C2, LastChangeTime) values(?, ?, ?)"; // MsSql
    	String sqlString = "insert into T1 (C1, C2, LastChangeDateTime) values(?, ?, ?)"; // CS
      dbCon = DriverManager.getConnection(Db.getUrl(), Db.getUserName(), Db.getUserPassword());
      if(dbCon != null){
        System.out.println("~ Connected to " + Db.getUrl());
      }
      pStm = dbCon.prepareStatement(sqlString);

      pStm.setObject(1, new Integer(1));
      pStm.setObject(2, new String("~~1a"));
//      pStm.setObject(3, new java.sql.Date(System.currentTimeMillis())); // db2
//      pStm.setObject(3, new Timestamp(System.currentTimeMillis())); // mssql
      pStm.setObject(3, new Timestamp(System.currentTimeMillis()));
      pStm.executeUpdate();

      //Thread.sleep(1000);
      pStm.setObject(1, new Integer(2));
      pStm.setObject(2, new String("~~2a"));
//      pStm.setObject(3, new java.sql.Date(System.currentTimeMillis())); // db2
//      pStm.setObject(3, new Timestamp(System.currentTimeMillis())); // mssql
      pStm.setObject(3, new Timestamp(System.currentTimeMillis()));
      pStm.executeUpdate();

      //Thread.sleep(3000);
      pStm.setObject(1, new Integer(3));
      pStm.setObject(2, new String("~~3a"));
//      pStm.setObject(3, new java.sql.Date(System.currentTimeMillis())); // db2
//      pStm.setObject(3, new Timestamp(System.currentTimeMillis())); // mssql
      pStm.setObject(3, new Timestamp(System.currentTimeMillis()));
      pStm.executeUpdate();

      System.out.println("~Rows inserted.");
    }catch(SQLException excpt){
      System.out.println("~ERROR: " + excpt.toString());
      excpt.printStackTrace(System.out);
    } finally {
      try{pStm.close();}catch(Exception ignore){}
      try{dbCon.close();}catch(Exception ignore){}
    }
    System.out.println("~~~~~~~~~~~ The END ~~~~~~~~~~~~~~~");
    //System.exit(0);
  }
}
