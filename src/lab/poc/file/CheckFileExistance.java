package lab.poc.file;
import java.io.*;

public class CheckFileExistance {
   public static void main(String[] args) {

      String s = null;
      File f = null;

      //~ Good
      s = "C:/APPS/James/james-2.2.0a10/bin/james-start.bat";
      f = new File(s);
      System.out.println("~ File: " + f.getPath() + " exists: " + f.exists());

      //~ Bad
      s = "C:/APPS/James/james-2.2.0a10/bin/james-start";
      f = new File(s);
      System.out.println("~ File: " + f.getPath() + " exists: " + f.exists());

      //~ Bad
      s = "C:/APPS/James/james-2.2.0a10/bin/james-startXXX";
      f = new File(s);
      System.out.println("~ File: " + f.getPath() + " exists: " + f.exists());
   }
}