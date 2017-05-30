package lab.poc.task;
import java.util.Date;

public class Task {

  public static void run(String[] parms, int errorCount) throws Exception{
    System.out.println("Task.run()   - " + new Date());
    System.out.println("ERROR D0001 " + Msg.D0001);
    ++errorCount;
  }
}
