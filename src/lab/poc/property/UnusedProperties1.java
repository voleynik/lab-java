package lab.poc.property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.Properties;

public class UnusedProperties1 {
  
  private static final File rootFolder = new File("C:\\projects\\tsa");
  
  //~ Property files to be checked.
  private static final String file1 = "C:\\projects\\tsa\\etc\\napa.properties";
  private static final String file2 = "C:\\projects\\tsa\\etc\\ApplicationResources.properties";
  private static final String[] files = {file1};
  
  //~ Start point ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void main(String[] args) throws Exception {
    
    //~ Process files
    for(int i = 0; i < files.length; i++){
      processProperties(files[i]);
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void printProperties(String pFile, Properties pProperties){
    System.out.println();
    System.out.println(pFile);
    Enumeration e = pProperties.propertyNames();
    while(e.hasMoreElements()){
      String propertyName = (String)e.nextElement();
      System.out.println("   " + propertyName + " = " + pProperties.getProperty(propertyName));
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void processProperties(String pFile) throws Exception{
    Properties p = new Properties();
    p.load( new FileInputStream(pFile));
    printProperties(pFile, p);
    Enumeration e = p.propertyNames();
    while(e.hasMoreElements()){
      checkPropertyInFolder((String)e.nextElement(), rootFolder);
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  private static void checkPropertyInFolder(String pProperty, File pFile) throws Exception{
    if(pFile.isDirectory()){
      checkPropertyInFolder(pProperty, pFile);       
    }else{
      checkPropertyInFile(pProperty, pFile);
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    
  private static void checkPropertyInFile(String pProperty, File pFile) throws Exception{
    BufferedReader br = new BufferedReader(new FileReader(pFile));
    String fileLine = null;
    while ((fileLine = br.readLine()) != null){
      if(fileLine.indexOf(pProperty) != -1){
        //vo@@
      }
    }
  }
} //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~