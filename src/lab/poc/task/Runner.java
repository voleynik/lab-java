package lab.poc.task;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

public class Runner {

  public static void run(String[] parms) throws Exception{
    int errorCount = 0;
    System.setOut(new PrintStream(new FileOutputStream(parms[0] + "\\Runner.log", true )));
    System.out.println("Runner.run() - " + new Date() + 
        " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    Daily.run(parms, errorCount);
    System.out.println("Number of errors: " + errorCount);
  }
  public static void main(String[] parms) {
    try {
      run(parms);
    } catch (Exception e) {
      // vo@@ Auto-generated catch block
      e.printStackTrace();
    }
  }
}
