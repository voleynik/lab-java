package lab.property;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
//~ 
public class RemoveUnused {
  
  private static final File oldArFile = new File("C:\\ApplicationResources-OLD.properties");
  private static final File newArFile = new File("C:\\ApplicationResources-NEW.properties");
  private static final File unusedPropertiesFile = new File("C:\\unused-ar.txt");
  private static final Properties unusedProperties = new Properties();
  private static BufferedWriter newFileWriter;
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
  public static void main(String[] args) throws Exception {
    newFileWriter = new BufferedWriter(new FileWriter(newArFile));
    loadUnusedProperties();
    processOldFile();
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void loadUnusedProperties() throws Exception {
    unusedProperties.load( new FileInputStream(unusedPropertiesFile));
  }  
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void processOldFile() throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(oldArFile));
    String fileLine = null;
    while ((fileLine = br.readLine()) != null){
      if( !fileLine.equals("") && !fileLine.equals(" ") && !fileLine.substring(0,1).equals("#") && !fileLine.substring(0,1).equals("ï")){
        checkLine(fileLine);
      }else{
        writeLine(fileLine);
      }       
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void checkLine(String pLine) throws Exception {
    try {
      if(isUsed(extractPropertyName(pLine))){
        writeLine(pLine);
      }
    } catch (Exception e) {
      System.out.println("~pLine: " + pLine);
      System.exit(1);
    }   
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void writeLine(String pLine) throws Exception {
    newFileWriter.write(pLine);
    newFileWriter.newLine();
    newFileWriter.flush(); 
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static String extractPropertyName(String pLine){
    int indexOfEqualSign = pLine.indexOf("=");
    for(int i = indexOfEqualSign; i > 0; i-- ){
      if( pLine.substring((i - 1), i).equals(" ") ){
        continue;
      }else{
        return pLine.substring(0, i);
      }  
    }
    return null;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static boolean isUsed(String pPropertyName){
    if(unusedProperties.getProperty(pPropertyName) == null){
      return true;
    }
    return false;
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void xx(){
  }
} //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
