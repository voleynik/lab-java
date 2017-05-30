package lab.poc.thread;

public class Singleton1 {

	private static Singleton1 myInst;
	
	public static Singleton1 getInstance() {
		
      if(myInst == null){
    	  
         synchronized(myInst){
        	 
            if(myInst == null){
            	
               try{
            	   
            	   myInst = new Singleton1();
            	   
               }catch(Exception excpt){
            	   
                  excpt.printStackTrace(System.out);
                  
               }finally{
                  System.out.println("Created Singleton1 instance: " + myInst);
               }
            }
         }
      }
	  return myInst;
	}
}
