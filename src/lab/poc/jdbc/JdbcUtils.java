package lab.poc.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class JdbcUtils {

	public static Connection getConnection() {
		Connection dbCon = null;
		try {
			dbCon =
				DriverManager.getConnection(
					Db.getUrl(),
					Db.getUserName(),
					Db.getUserPassword());
			return dbCon;

		} catch (SQLException excpt) {
			System.out.println("~Can't get a connection from: " + Db.getUrl());
			excpt.printStackTrace(System.out);
		}
		return null;
	}

	public static DatabaseMetaData getDbMetaData() {
		try {
			return getConnection().getMetaData();
		} catch (SQLException excpt) {
			System.out.println("~Can't get a meta data from: " + Db.getUrl());
			excpt.printStackTrace(System.out);
		}
		return null;
	}
  
  public static void printResultSet(ResultSet rSet) {
    List allRows = null;
    List row = null;
    try{
      allRows = processResultSet(rSet);
      for(int i = 0; i < allRows.size(); i++ ){
        row = (List)allRows.get(i);
        for(int j = 0; j < row.size(); j++ ){
          System.out.println("" + row.get(j));
        }
      }
    }catch(Exception excpt){
      System.out.println("ERROR: Can NOT print Result Set.");
    }
  }
  
  /**
   * @return list of lists with objects.
   */
  public static List processResultSet(ResultSet rSet) throws SQLException{
    List allRows = Collections.synchronizedList(new ArrayList());
    List colNames = Collections.synchronizedList(new ArrayList());
    List row = null;
    ResultSetMetaData rSetMd = rSet.getMetaData();
    int numlberOfColumns = rSetMd.getColumnCount();
    for(int i = 1; i <= numlberOfColumns; i++){
      colNames.add(rSetMd.getColumnName(i));
    }
    allRows.add(colNames);//~ The first array is column names.
    while(rSet.next()){
      row = Collections.synchronizedList(new ArrayList());
      for(int i = 1; i <= numlberOfColumns; i++){
        row.add(rSet.getObject(i));
      }
      allRows.add(row);
    }
    return allRows;
  }
}