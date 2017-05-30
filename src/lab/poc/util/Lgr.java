package lab.util;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Lgr {
	
	//~ Constants.
	private static final String SPACE = " ";
	private static final ClassNameGetter cng = new ClassNameGetter();
	private static final String timeStampDefaultFormat = "yyMMdd-HHmmss";
	private static final SimpleDateFormat sdf = (SimpleDateFormat)DateFormat.getDateInstance(DateFormat.LONG);
	
	//~ Attributes.
	private static PrintStream printStream = System.out;
	private static PrintWriter printWriter = new PrintWriter(printStream);
	public static  String appName = "";
	private static String timeStampFormat = getTimeStampFormat(timeStampDefaultFormat);
	public static String userId = System.getProperty("user.name");
	
	//~ Switches.
	public static boolean active = true;
	public static boolean printAppName = false;
	public static boolean printTimeStamp = false;
	public static boolean printThreadName = false;
	public static boolean printClass = false;
	public static boolean printMethod = false;
	public static boolean printEntryType = false;
	public static boolean printUser = false;
	
	//~ Timestamp.
	private static String getTimeStampFormat(String tsf){
		sdf.applyPattern(tsf);
		return tsf;
	}
	public static void setTimeStampFormat(String tsf){
		timeStampFormat = tsf;
		sdf.applyPattern(tsf);
	}
	
	//~ Class name getter.
	private static class ClassNameGetter extends SecurityManager {
	    public String getClassName() {
	      return getClassContext()[2].getName();
	    }
	}
	
	//~ Method name getter.
	private static String getMethodName(Throwable e ){
		return e.getStackTrace()[0].getMethodName();
	}
	
	//~ Default configuration.
	static {
		active = true;
		printAppName = false;
		printTimeStamp = true;
		printThreadName = true;
		printClass = true;
		printMethod = true;
		printEntryType = false;
		printUser = false;
	}
	
	//~ Printing methods.
	public static void log(Throwable e, String msg) {
		if(!active)return;
		StringBuffer sb = new StringBuffer();
		if(!appName.equalsIgnoreCase("") && printAppName)                           //~ App name
			sb.append(appName).append(SPACE);
		if(printTimeStamp)                                                          //~ Time
			sb.append(sdf.format(Calendar.getInstance().getTime())).append(SPACE);
		if(printThreadName)                                                         //~ Tread
			sb.append(Thread.currentThread().getName()).append(SPACE); 
		if(printClass)                                                              //~ Class name
			sb.append(cng.getClassName());
		if(printClass && printMethod)                                               
			sb.append(".");
		else
			sb.append(SPACE);
		if(printMethod && e != null)                                            	//~ Method name
			sb.append(getMethodName(e)).append("()").append(SPACE);
	       
	     sb.append(msg);                                                            //~ Message
	     
	     if(printUser)                                                          	//~ User
	     	sb.append(" USR: ").append(userId);
	     
	     printStream.println( sb.toString());	
	}
		
	public static void log(String method, String msg) {
		if(!active)return;
		StringBuffer sb = new StringBuffer();
		if(!appName.equalsIgnoreCase("") && printAppName)                           //~ App name
			sb.append(appName).append(SPACE);
		if(printTimeStamp)                                                          //~ Time
			sb.append(sdf.format(Calendar.getInstance().getTime())).append(SPACE);
		if(printThreadName)                                                         //~ Tread
			sb.append(Thread.currentThread().getName()).append(SPACE); 
		if(printClass)                                                              //~ Class name
			sb.append(cng.getClassName());
		if(printClass && printMethod)                                               
			sb.append(".");
		else
			sb.append(SPACE);
		if(printMethod)                                            	                //~ Method name
			sb.append(method).append("()").append(SPACE);
	       
	     sb.append(msg);                                                            //~ Message
	     
	     if(printUser)                                                          	//~ User
	     	sb.append(" USR: ").append(userId);
	     
	     printStream.println( sb.toString());	
	}
}