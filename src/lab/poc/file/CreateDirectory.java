package lab.poc.file;
import java.io.*;

public class CreateDirectory {
   public static void main(String[] args) {



      try {

//         File l_file = new File("C:\\TEMP\\vo-temp\\vo-temp.txt");
         File l_dir = new File("C:\\TEMP\\vo-temp\\");
         if(!l_dir.exists()){
            l_dir.mkdir();
         }

      }
      catch (Exception ex) {
         ex.printStackTrace(System.out);
      }



   }
}