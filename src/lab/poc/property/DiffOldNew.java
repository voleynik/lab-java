package lab.poc.property;

import java.io.File;
import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class DiffOldNew {
  private static final File oldArFile = new File("C:\\ApplicationResources-OLD.properties");
  private static final File newArFile = new File("C:\\ApplicationResources-NEW.properties");
  private static final File unusedArFile = new File("C:\\unused-ar.txt"); 
  private static Properties oldProperties = new Properties();
  private static Properties newProperties = new Properties();
  private static Properties unusedProperties = new Properties();
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) throws Exception{
    loadAll();
    Enumeration e = oldProperties.propertyNames();
    String propertyKey = null;
    while(e.hasMoreElements()){
      propertyKey = (String)e.nextElement();
      if( newProperties.getProperty(propertyKey) == null){ //~ Unused
        if( unusedProperties.getProperty(propertyKey) == null ){ //~ Lost
          System.out.println("~propertyKey: " + propertyKey );
        }  
      }
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void loadAll() throws Exception {
    oldProperties.load( new FileInputStream(oldArFile));
    newProperties.load( new FileInputStream(newArFile));
    unusedProperties.load( new FileInputStream(unusedArFile));    
  }
} //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

