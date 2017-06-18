package lab.interview;
import java.util.concurrent.locks.*;

public class Deadlock9 {

    public static class Table {

        private static Lock flashlight = new ReentrantLock();
        private static Lock batteries = new ReentrantLock();        

        public static void giveFlashLightAndBatteries() {
            try {
                System.out.println(Thread.currentThread().getName() + " TRYING to locked flashlight and batteries.");
                flashlight.lock();
                batteries.lock();
                System.out.println(Thread.currentThread().getName() + " locked flashlight and batteries.");
            } finally {
                batteries.unlock();
                flashlight.unlock();
            }
        }

        public static void giveBatteriesAndFlashLight() {
            try {
                System.out.println(Thread.currentThread().getName() + " TRYING to locked batteries and flashlight...");
                batteries.lock();
                flashlight.lock();
                System.out.println(Thread.currentThread().getName() + " locked batteries and flashlight.");
            } finally {
                flashlight.unlock();
                batteries.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // This thread represents person one
        Thread t1 = new Thread(new Runnable() {
            public void run() { Table.giveFlashLightAndBatteries(); }
        });
        t1.setName("T1");

        // This thread represents person two
        Thread t2 = new Thread(new Runnable() {
            public void run() { Table.giveBatteriesAndFlashLight(); }
        });
        t2.setName("T2");
  
        t1.start();
        t2.start();
       
        try {
			t1.join();
	        t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("The end.");
    }
}
