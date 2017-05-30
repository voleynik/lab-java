package lab.poc.time;

public class ConvertLong {
	public static void main(String[] args) {
		
//		System.out.println("Now:          " + (new java.util.Date()).getTime());
//		System.out.println("Now - 24hrs:  " + ((new java.util.Date()).getTime() - DateUtil.DAY_IN_MILLS));
	
		long fourHoursInMills = 14400000L;
		long time = 0L;
		for(int i = 0; i < 10; i++){	
			System.out.println();
			time = (new java.util.Date()).getTime() + ( fourHoursInMills * (i + 1));
			System.out.print( ((new java.util.Date()).getTime() + (fourHoursInMills * (i + 1))));
			System.out.println( " - " + new java.util.Date( time));
		}
		
		
		System.out.println("Now + 5 min: " + (( new java.util.Date()).getTime() + 300000 ));
		System.out.println("Now + 5 min: " + ( new java.util.Date(( new java.util.Date()).getTime() + 300000 )));

		long time2 = 1085684645888L;
		System.out.println("\n long: " + time2 + " = " + new java.util.Date(time2));
		
	}
}