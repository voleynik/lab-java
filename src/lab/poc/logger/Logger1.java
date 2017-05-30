package lab.logger;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.PrintStream;
                                      //~~~ ARCHIVE - DO NOT CHANGE. ~~~~~~~~~~~~~~~~~~~
public class Logger1 {

   public static String entryPrefix = "";
   public static boolean active = true;
   public static boolean printTimeStamp = false;
   public static boolean printThreadName = false;
   private static PrintStream printStream = System.out;

   public static void log(String p0) {
      if(!active)return;
      StringBuffer sb = new StringBuffer();
      if(!entryPrefix.equalsIgnoreCase(""))sb.append(entryPrefix).append(" ");
      if(printTimeStamp)sb.append(stamp()).append(" ");
      if(printThreadName)sb.append(Thread.currentThread().getName()).append(" ");
      sb.append(new ClassNameGetter().getClassName()).append(".");
      sb.append(new Exception().getStackTrace()[1].getMethodName()).append("()");
      sb.append(" ~ ").append(p0);
      printStream.println( sb.toString());
   }

   public static String stamp(){
      SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.LONG);
      sdf.applyPattern("yyMMdd-HHmmss");
      return (sdf.format(Calendar.getInstance().getTime()));
   }

   public static class ClassNameGetter extends SecurityManager {
    public String getClassName() {
      return getClassContext()[2].getName();
    }
  }
}