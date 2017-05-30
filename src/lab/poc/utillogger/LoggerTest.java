package lab.utillogger;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerTest {
	
	private static Logger lgr = Logger.getAnonymousLogger();
	private static Handler hlr;
	
	public static void main(String[] args) {
		
//		try {
//			hlr = new FileHandler("vo-err", 1000, 10);
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		hlr.setFormatter(new SimpleFormatter());
//		lgr.addHandler(hlr);
		lgr.setLevel(Level.ALL);
		lgr.severe("test");
	}
}
