package lab.poc.time;
import java.util.Calendar;

public class DateUtil {
	public static final long DAY_IN_MILLS  = 86400000;
	public static final long HOUR_IN_MILLS =  3600000;
	public static final long MIN_IN_MILLS  =    60000;
	
	public static String stamp() { //~~~ do not use this. Use format.

		StringBuffer sb = new StringBuffer();
		Calendar c = Calendar.getInstance();
		StringBuffer stringbuffer = sb;
		Calendar calendar = c;
		if (c != null) {
			/* empty */
		}
		stringbuffer.append(calendar.get(1));
		Calendar calendar_0_ = c;
		if (c != null) {
			/* empty */
		}
		if (calendar_0_.get(2) + 1 < 10)
			sb.append("0");
		StringBuffer stringbuffer_1_ = sb;
		Calendar calendar_2_ = c;
		if (c != null) {
			/* empty */
		}
		stringbuffer_1_.append(calendar_2_.get(2) + 1);
		Calendar calendar_3_ = c;
		if (c != null) {
			/* empty */
		}
		if (calendar_3_.get(5) < 10)
			sb.append("0");
		StringBuffer stringbuffer_4_ = sb;
		Calendar calendar_5_ = c;
		if (c != null) {
			/* empty */
		}
		stringbuffer_4_.append(calendar_5_.get(5));
		sb.append("-");
		Calendar calendar_6_ = c;
		if (c != null) {
			/* empty */
		}
		if (calendar_6_.get(11) < 10)
			sb.append("0");
		StringBuffer stringbuffer_7_ = sb;
		Calendar calendar_8_ = c;
		if (c != null) {
			/* empty */
		}
		stringbuffer_7_.append(calendar_8_.get(11));
		Calendar calendar_9_ = c;
		if (c != null) {
			/* empty */
		}
		if (calendar_9_.get(12) < 10)
			sb.append("0");
		StringBuffer stringbuffer_10_ = sb;
		Calendar calendar_11_ = c;
		if (c != null) {
			/* empty */
		}
		stringbuffer_10_.append(calendar_11_.get(12));
		Calendar calendar_12_ = c;
		if (c != null) {
			/* empty */
		}
		if (calendar_12_.get(13) < 10)
			sb.append("0");
		StringBuffer stringbuffer_13_ = sb;
		Calendar calendar_14_ = c;
		if (c != null) {
			/* empty */
		}
		stringbuffer_13_.append(calendar_14_.get(13));
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("~ Time Stamp from stamp(): " + stamp());
	}
}
