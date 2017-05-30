package lab.poc.logger;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Logger {

  //~ Log entry example with complete list of elements.
  //~ TSA 40909-121721.825 Tread 2 com.pk1.pk11.Class1method1()ERR - text|USR:voadmin
  //~ ERR, INF, WRN.
  //~~~~~~~~~~~~~~~~~~ Constants ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static final String SPACE = " ";
  private static final String timeStampDefaultFormat = "yyMMdd-HHmmss";
  private static final PrintWriter printWriter = new PrintWriter(System.out);
  private static final SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.LONG);
  private static PrintStream printStream = System.out;
  
  //~~~~~~~~~~~~~~~~~~ Properties ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static String appId = "";
  public static String timeStampFormat = timeStampDefaultFormat;
  public static String entryType = "INF";
  public static String userId = null;
  
  //~~~~~~~~~~~~~~~~~~ Switches ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static boolean active = true;
  public static boolean printAppId = false;
  public static boolean printTimeStamp = false;
  public static boolean printThreadName = false;
  public static boolean printClass = false;
  public static boolean printMethod = false;
  public static boolean printEntryType = false;
  public static boolean printUser = false;
  
  public static void printAll(){
//   active = true;
   printAppId = true;
   printTimeStamp = true;
   printThreadName = true;
   printClass = true;
   printMethod = true;
   printEntryType = true;
   printUser = true;
  }
   
   static{
     sdf.applyPattern(timeStampFormat);
   }
   
  public static class ClassNameGetter extends SecurityManager {
    public String getClassName() {
      return getClassContext()[2].getName();
    }
  }
   
   private static void log(Throwable excpt, String p0) {
     if(!active)return;
     StringBuffer sb = new StringBuffer();
     if(!appId.equalsIgnoreCase("") && printAppId)                               //~ AppId
       sb.append(appId).append(SPACE);
     if(printTimeStamp)                                                          //~ Time
       sb.append(sdf.format(Calendar.getInstance().getTime())).append(SPACE);
     if(printThreadName)                                                         //~ Tread
       sb.append(Thread.currentThread().getName()).append(SPACE); 
     if(printClass)                                                              //~ Class name
       sb.append(new ClassNameGetter().getClassName());
     if(printClass && printMethod)                                               
       sb.append(".");
     else
       sb.append(SPACE);
     if(printMethod && excpt != null)                                            //~ Method name
       sb.append(excpt.getStackTrace()[1].getMethodName()).append("()").append(SPACE);
     if(printEntryType)                                                          //~ Entry type
       sb.append(entryType).append(SPACE);
       
     sb.append(p0);                                                              //~ Message
     
     if(printUser)                                                          	//~ User
       sb.append(entryType).append(SPACE);
     
     printStream.println( sb.toString());
   }
   
   public static void error(Throwable excpt, String errMsg){
     entryType = "ERR";
   }
   public static void warn(){
     entryType = "WRN";
   }
   public static void info(String p0){
     entryType = "INF";
   }
}