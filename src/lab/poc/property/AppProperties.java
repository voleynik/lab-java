package lab.poc.property;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import lab.poc.util.IConstant;

/**
 * This class loads and holds properties from 'app.properties' file.
 */
public class AppProperties {
  private static String appPropertiesPath;
  private static Properties appProperties = new Properties();
  private AppProperties(){}
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void init() throws FileNotFoundException, IOException {
    InputStream is = new FileInputStream(appPropertiesPath);
    appProperties.load(is);
    print();
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String getProperty(String key){
    return appProperties.getProperty(key);
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  public static void setProperty(String key, String value) {
    appProperties.setProperty(key, value);
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void print(){
    System.out.println();
    System.out.println("Listing " + appPropertiesPath + " . . .");
    Enumeration propNames = appProperties.keys();
    while (propNames.hasMoreElements()) {
      String propName = (String)propNames.nextElement();
      String propValue = (String)appProperties.get(propName);
      System.out.println(" " + propName + " = " + propValue);
    }
    System.out.println();
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  /** 
   * @param String - the complete path of app's WEB-INF folder.
   */
  public static void init(String fileLocation){
    appPropertiesPath = fileLocation + System.getProperty("file.separator") + 
      IConstant.APP_PROPERTIES;
      try{
        AppProperties.init();
      }catch(FileNotFoundException excpt){
        System.out.println("ERROR - Can not find file -> " + appPropertiesPath);
      }catch(IOException excpt){
        System.out.println("ERROR - Can not read file -> " + appPropertiesPath);
      }
    }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  public static void main(String[] args) {
    init("C:\\APPS\\Apache\\jakarta-tomcat-5.0.18\\webapps\\dba\\WEB-INF\\properties");
  }
}
