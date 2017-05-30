package lab.logger;

public class LoggerTest {
	public static void main(String[] args) {
		Logger.active = true;
		Logger.printThreadName = true;
		Logger.printTimeStamp = true;
		//      Logger.entryPrefix = "~LAB";

		Logger.info("Hello world 1!");

		new Thread("Thread 1") {
			public void run() {
				Logger.info("Hello world 2!");
			}
		}.start();

		new Thread("Thread 2") {
			public void run() {
				Logger.info("Hello world 3!");
			}
		}.start();

		anotherMethod();
	}

	public static void anotherMethod() {
		Logger.info("Hello world 4!");
	}
}