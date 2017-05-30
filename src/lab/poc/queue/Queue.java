package lab.poc.queue;
import java.util.*;

class Queue {

   private List taskList = Collections.synchronizedList(new ArrayList());
   private int maxQueueSize = 10;
   private int totalTaskCount = 0;

   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   public Task get(){
      Task currentTask = null;
      
      synchronized(taskList){
         while(taskList.size() < 1){
            try{
               taskList.wait();
            } catch (InterruptedException e) {
               e.printStackTrace(System.err);
               return null;
            }
         }
         currentTask = (Task)taskList.get(0);
         taskList.remove(0);
         taskList.notifyAll();
      }//~~~ sync
      return currentTask;
   }

   //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   public void put(Task tsk, Producer pcr){
	   
      synchronized(taskList){
         while(taskList.size() >= maxQueueSize){
            try{
               taskList.wait();
            } catch (InterruptedException e) {
               e.printStackTrace(System.err);
               return;
            }
         }
         tsk.setName( tsk.getName() + "." + totalTaskCount++ );
         taskList.add(tsk);
         System.out.println("~ Task " + tsk.name + " was added by " + pcr.name);
         taskList.notifyAll();
      }//~~~ sync
   }
}