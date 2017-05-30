package lab.task;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Daily {

  public static void run(String[] parms, int errorCount) throws Exception{
    List<String> errorCodes = new ArrayList<String>();
    System.out.println("Daily.run()   - " + new Date());
    Task.run(parms, errorCount);
  }
}
