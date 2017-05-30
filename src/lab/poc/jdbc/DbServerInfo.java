package lab.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import lab.property.AppProperties;

public class DbServerInfo {
//private DatabaseMetaData dbmd;
  private DbServerInfo(){}//~ No instantiation.

  public static void main(String[] args) {
    String fileLocation = 
      "C:\\APPS\\Apache\\jakarta-tomcat-5.0.18\\webapps\\dba\\WEB-INF\\properties";
    Connection dbCon = null;
//    AppProperties.init(fileLocation);
    try{
      dbCon = JdbcUtils.getConnection();
      DatabaseMetaData dbmt = dbCon.getMetaData();
      
      //~ ResultSets.
      System.out.println("");
      System.out.println("Catalogs:");
      JdbcUtils.printResultSet(dbmt.getCatalogs()); 
      
      System.out.println("");
      System.out.println("Schemas:");
      JdbcUtils.printResultSet(dbmt.getSchemas());
      
      System.out.println("");
      System.out.println("Table types:");
      JdbcUtils.printResultSet(dbmt.getTableTypes());    
      
      //~~~ Use loop
//      System.out.println("");
//      System.out.println("Data types:");
//      Db.printResultSet(dbmt.getTypeInfo());  

      //~ Strings.
      System.out.println("");
      
      System.out.println("URL:                     " + dbmt.getURL());
      System.out.println("User Name:               " + dbmt.getUserName());
      System.out.println("DatabaseProductName:     " + dbmt.getDatabaseProductName());
      System.out.println("DatabaseProductVersion:  " + dbmt.getDatabaseProductVersion());
      System.out.println("DriverName:              " + dbmt.getDriverName());
      System.out.println("DriverVersion:           " + dbmt.getDriverVersion());
      System.out.println("DriverMajorVersion:      " + dbmt.getDriverMajorVersion());
      System.out.println("DriverMinorVersion:      " + dbmt.getDriverMinorVersion());
      System.out.println("ExtraNameCharacters:     " + dbmt.getExtraNameCharacters());
      System.out.println("NumericFunctions:        " + dbmt.getNumericFunctions());
      System.out.println("CatalogSeparator:        " + dbmt.getCatalogSeparator());
      System.out.println("CatalogTerm:             " + dbmt.getCatalogTerm());
      System.out.println("IdentifierQuoteString:   " + dbmt.getIdentifierQuoteString());
      System.out.println("SchemaTerm:              " + dbmt.getSchemaTerm());
      System.out.println("ProcedureTerm:           " + dbmt.getProcedureTerm());
      System.out.println("SQLKeywords:             " + dbmt.getSQLKeywords());      
      System.out.println("StringFunctions:         " + dbmt.getStringFunctions());
      System.out.println("SystemFunctions:         " + dbmt.getSystemFunctions());
      System.out.println("TimeDateFunctions:       " + dbmt.getTimeDateFunctions());  
      System.out.println("SearchStringEscape:      " + dbmt.getSearchStringEscape());
      System.out.println("TypeInfo:                " + dbmt.getTypeInfo());
      System.out.println("CatalogAtStart:          " + dbmt.isCatalogAtStart());
      System.out.println("isReadOnly:              " + dbmt.isReadOnly());    
      System.out.println("DefaultTransactionIsolation: " + dbmt.getDefaultTransactionIsolation());
       
      //~ Maximums.
      System.out.println("");
      System.out.println("Maximums:");
      System.out.println("MaxBinaryLiteralLength:  " + dbmt.getMaxBinaryLiteralLength());
      System.out.println("MaxCatalogNameLength:    " + dbmt.getMaxCatalogNameLength()); 
      System.out.println("MaxCharLiteralLength:    " + dbmt.getMaxCharLiteralLength()); 
      System.out.println("MaxColumnNameLength:     " + dbmt.getMaxColumnNameLength()); 
      System.out.println("MaxColumnsInGroupBy:     " + dbmt.getMaxColumnsInGroupBy()); 
      System.out.println("MaxColumnsInIndex:       " + dbmt.getMaxColumnsInIndex()); 
      System.out.println("MaxColumnsInOrderBy:     " + dbmt.getMaxColumnsInOrderBy()); 
      System.out.println("MaxColumnsInSelect: " + dbmt.getMaxColumnsInSelect()); 
      System.out.println("MaxColumnsInTable: " + dbmt.getMaxColumnsInTable()); 
      System.out.println("MaxConnections: " + dbmt.getMaxConnections()); 
      System.out.println("MaxCursorNameLength: " + dbmt.getMaxCursorNameLength()); 
      System.out.println("MaxIndexLength: " + dbmt.getMaxIndexLength()); 
      System.out.println("MaxProcedureNameLength: " + dbmt.getMaxProcedureNameLength()); 
      System.out.println("MaxMaxRowSize: " + dbmt.getMaxRowSize()); 
      System.out.println("MaxSchemaNameLength: " + dbmt.getMaxSchemaNameLength()); 
      System.out.println("MaxStatementLength: " + dbmt.getMaxStatementLength()); 
      System.out.println("MaxStatements: " + dbmt.getMaxStatements()); 
      System.out.println("MaxTableNameLength: " + dbmt.getMaxTableNameLength()); 
      System.out.println("MaxTablesInSelect: " + dbmt.getMaxTablesInSelect()); 
      System.out.println("MaxUserNameLength: " + dbmt.getMaxUserNameLength()); 
    
    }catch(Exception excpt){
      System.out.println("ERROR - Can NOT connect to db!");
    }finally{
      try { dbCon.close(); } catch (SQLException e) {}
    }
  }
}
