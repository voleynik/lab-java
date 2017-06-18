package lab.interview;

public class DeadLock2 {

	private static Object lock1 = new Object();
	private static Object lock2 = new Object();

	public static void doA(){
        synchronized(lock1) {
            try {
            	Thread.sleep(500);
            } catch (Exception e) {
            	//
            }
            synchronized(lock2) {
            }
		} 
        System.out.println("Finish doA()");
	}
	
	public static void doB(){
        synchronized(lock2) {
            try {
    			Thread.sleep(500);
    		} catch (Exception e) {
    			//
    		}
            synchronized(lock1) {
    		}
		}
        System.out.println("Finish doB()");
	}
	
	public static void main(String[] args) {
        new Thread(new Runnable(){
            public void run() { doA(); }
        }).start();
        new Thread(new Runnable(){
            public void run() { doB(); }
        }).start();
        System.out.println("Finish main()");
	}
}