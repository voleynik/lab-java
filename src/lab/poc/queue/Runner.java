package lab.poc.queue;

public class Runner {
	public static void main(String[] args) {
		Queue tq = new Queue();
		Producer p01 = new Producer("P01", tq, 1000, true);
		Producer p02 = new Producer("P02", tq, 2000, true);
		Producer p03 = new Producer("P03", tq, 3000, true);
		Producer p04 = new Producer("P04", tq, 4000, true);
		Producer p05 = new Producer("P05", tq, 5000, true);
		Consumer c01 = new Consumer("C01", tq, 5000, true);
		Consumer c02 = new Consumer("C02", tq, 4000, true);
		Consumer c03 = new Consumer("C03", tq, 3000, true);
		Consumer c04 = new Consumer("C04", tq, 2000, true);
		Consumer c05 = new Consumer("C05", tq, 1000, true);
		c04.start();
		p03.start();
		c03.start();
		p01.start();
		c05.start();
		p02.start();
		c01.start();
		p04.start();
		c02.start();
		p05.start();
		try {
			Thread.currentThread();
			Thread.sleep(30000L);
			System.exit(0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
