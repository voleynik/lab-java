package lab.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlRunner {
  
  private SqlRunner(){}; //~ Can not be instantiated.

  /***************************************************************************
   * Run any "select" prepared statement and return a jdbc result set object.
   */
  public static ResultSet runQuery(Connection pConnection, String sqlStatemnt, Object[] statementParameters){
        
    //~ If null object received, make an empty one.
    if(statementParameters == null) statementParameters = new Object[0];
    
    try{
      PreparedStatement lPreparedStatement = pConnection.prepareStatement(sqlStatemnt);

      //~ Set sql parms represented by ?.
      for(int i = 0; i < statementParameters.length; i++){
        lPreparedStatement.setObject((i + 1), statementParameters[i]);
      }
      
      //~ Run the statemnt and return ResultSet.
      return lPreparedStatement.executeQuery();
      
    }catch(Exception excpt){
      processException(excpt, sqlStatemnt, statementParameters);
    }finally{
      //~ Do not close or return connection to the pool.
    }
    return null;
  }
  
  //~ No-sql-parms convenience method.
  public static ResultSet runQuery(Connection pConnection, String sqlStatemnt){
    return runQuery(pConnection, sqlStatemnt, null);
  }
 
  /******************************************************************************
   * Run any "non-select" prepared statement and return a count of effected rows.
   */
  public static int runUpdate(Connection pConnection, String sqlStatemnt, Object[] statementParameters){
 
    //~ If null object received, make an empty one.
    if(statementParameters == null) statementParameters = new Object[0];
    
    try{
      PreparedStatement lPreparedStatement = pConnection.prepareStatement(sqlStatemnt);

      //~ Set sql parms represented by ?.
      for(int i = 0; i < statementParameters.length; i++){
        lPreparedStatement.setObject((i + 1), statementParameters[i]);
      }
      
      //~ Run the statemnt and return count of effected rows.
      return lPreparedStatement.executeUpdate();
      
    }catch(Exception excpt){
      processException(excpt, sqlStatemnt, statementParameters);
    }finally{
      //~ Do not close or return connection to the pool.
    }
    return 0;
  }
  
  //~ No-sql-parms convenience method.
  public static int runUpdate(Connection pConnection, String sqlStatemnt){
    return runUpdate(pConnection, sqlStatemnt, null);
  }
 
  //~ Common method to process all exceptions in the class.
  private static void processException(Exception excpt, String sqlStatemnt, Object[] statementParameters){
    System.err.println("ERROR processing SQL statement:");
    System.err.println(sqlStatemnt);
    System.err.println("with the following parameters:");
    for(int i = 0; i < statementParameters.length; i++){
      System.out.println(statementParameters[i]);
    }
    excpt.printStackTrace(System.err); 
  }
  /******************************************************************************
   * Run any "non-select" prepared statement and return a count of effected rows.
   */
  public static int runUpdate(String sqlStatement, Object[] statementParameters) throws Exception{
 
    //~ If null object received, make an empty one.
  	if(statementParameters == null) statementParameters = new Object[0];
    Connection dbCon = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    try{
    	dbCon = Db.getConnection();
		pst = dbCon.prepareStatement(sqlStatement);

      	//~ Set sql parms represented by ?.
      	for(int i = 0; i < statementParameters.length; i++){
      		pst.setObject((i + 1), statementParameters[i]);
      	}
      
      //~ Run the statemnt and return count of effected rows.
      return pst.executeUpdate();
      
    	}catch(Exception excpt){
    		printException(excpt, sqlStatement, statementParameters);
    		throw excpt;
      	}finally{
      		try{rs.close();}catch(Exception ignore){}
      		try{pst.close();}catch(Exception ignore){}
      		try{dbCon.close();}catch(Exception ignore){}
	}
  }
  
  //~ No-sql-parms convenience method.
  public static int runUpdate(String sqlStatemnt) throws Exception {
    return runUpdate(sqlStatemnt, null);
  }
  
  //~ Common method to process all exceptions in the class.
  private static void printException(Exception excpt, String sqlStatemnt, Object[] statementParameters){
    System.err.println("ERROR processing SQL statement:");
    System.err.println(sqlStatemnt);
    System.err.println("with the following parameters:");
    for(int i = 0; i < statementParameters.length; i++){
      System.err.println(statementParameters[i]);
    }
  }
}
