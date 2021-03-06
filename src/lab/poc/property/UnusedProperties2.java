package lab.poc.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
//~ Works OK. Too slow.
public class UnusedProperties2 {
  
  private static final File rootFolder = new File("C:\\projects\\tsa\\src");
  
  //~ File types to search.
  private static final String[] fileTypes = {".java", ".jsp", ".js", ".jsi"};
  
  //~ Property files to be checked.
  private static final String file1 = "C:\\projects\\tsa\\etc\\napa.properties";
  private static final String file2 = "C:\\projects\\tsa\\etc\\ApplicationResources.properties";

  private static List unUsedProperties = new ArrayList();
  private static List usedProperties = new ArrayList();
  private static Object[] allProperties;
  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) throws Exception {      
    loadAllProperties(); //~ Create String[] allProperties
    checkPropertiesInItem(rootFolder);
    printUnUsedProperties();
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void printProperties(Properties pProperties) throws Exception {
    int propertyCounter = 1;
    System.out.println();
    Enumeration e = pProperties.propertyNames();
    while(e.hasMoreElements()){
      String propertyName = (String)e.nextElement();
      System.out.println("" + (propertyCounter++) + " " + propertyName + 
        " = " + pProperties.getProperty(propertyName));
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void printUnUsedProperties() throws Exception{
    
    for(int i = 0; i < allProperties.length; i++){
      if( ! usedProperties.contains(allProperties[i])){
        unUsedProperties.add(allProperties[i]);
      }
    }
    int unUsedCounter = 1;
    System.setOut(new PrintStream(new FileOutputStream("C:\\unused-tsa-properties.txt")));
    for( int i = 0; i < unUsedProperties.size(); i++){
      System.out.println("" + (unUsedCounter++) + " " + unUsedProperties.get(i));
    }
  }  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void loadAllProperties() throws Exception {
    Properties p = new Properties();
    p.load( new FileInputStream(file1));
//    p.load( new FileInputStream(file2));
//    printProperties(allProperties);
    Enumeration e = p.propertyNames();
    List allKeys = new ArrayList();
    while(e.hasMoreElements()){
      allKeys.add(e.nextElement());
    }
    allProperties = allKeys.toArray(); 
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  private static void checkPropertiesInItem(File pFile) throws Exception{
    if(pFile.isDirectory()){
      processItemsInDirectory(pFile);       
    }else{
      if(needToCheck(pFile)){
        checkPropertiesInFile(pFile);
      }        
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static boolean needToCheck(File pFile) {
    boolean needToCheck = false;
    String fileExtention = pFile.getPath().substring(pFile.getPath().lastIndexOf("."));
    for( int i = 0; i < fileTypes.length; i++ ){
      if(fileExtention.equalsIgnoreCase(fileTypes[i])){
        needToCheck = true;
      }
    }
    return needToCheck;
  }  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void processItemsInDirectory(File pFolder) throws Exception {
    File[] itemsInFolder = pFolder.listFiles();
    for(int i = 0; i < itemsInFolder.length; i++){
      checkPropertiesInItem(itemsInFolder[i]);
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void checkPropertiesInFile(File pFile) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(pFile));
    String fileLine = null;
    while ((fileLine = br.readLine()) != null){
      checkPropertiesInLine(fileLine);
    }
  }  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void checkPropertiesInLine(String pLine) throws Exception {
    for(int i = 0; i < allProperties.length; i++){
      String propertyName = (String)allProperties[i];
      if( ! usedProperties.contains(propertyName )){
        if(pLine.indexOf(propertyName) != -1){
          usedProperties.add(propertyName);
        }
      }     
    }
  }  
} //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

