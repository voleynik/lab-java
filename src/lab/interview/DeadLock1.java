package lab.interview;

import java.util.concurrent.locks.*;

public class DeadLock1 {

    public static class Table {

        private static Lock Flashlight = new ReentrantLock();
        private static Lock Batteries = new ReentrantLock();        

        public static void giveFlashLightAndBatteries() {
            System.out.println(Thread.currentThread().getName() + " TRYING to locked flashlight and batteries.");
            try {
                Flashlight.lock();
                Thread.sleep(500);
                Batteries.lock();
                System.out.println(Thread.currentThread().getName() + " locked flashlight and batteries.");
            }catch(Exception e){
            	e.printStackTrace();
            } finally {
                Batteries.unlock();
                Flashlight.unlock();
            }
        }

        public static void giveBatteriesAndFlashLight() {
            System.out.println(Thread.currentThread().getName() + " TRYING to locked batteries and flashlight...");
            try {
                Batteries.lock();
                Thread.sleep(500);
                Flashlight.lock();
                System.out.println(Thread.currentThread().getName() + " locked batteries and flashlight.");
            }catch(Exception e){
            	e.printStackTrace();
            } finally {
                Flashlight.unlock();
                Batteries.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // This thread represents person one
        new Thread(new Runnable() {
            public void run() { Table.giveFlashLightAndBatteries(); }
        }).start();

        // This thread represents person two
        new Thread(new Runnable() {
            public void run() { Table.giveBatteriesAndFlashLight(); }
        }).start();
        
        System.out.println(Thread.currentThread().getName() + " Finished.");
    }
}