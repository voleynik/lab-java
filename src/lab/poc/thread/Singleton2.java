package lab.poc.thread;

public class Singleton2 {

	private static Singleton2 singleInstance;
	
	public static Singleton2 getInstance() {
		
      if(singleInstance == null){
    	  
         synchronized(Singleton2.class){
        	 
            if(singleInstance == null){
               try{
            	   singleInstance = new Singleton2();
               }catch(Exception excpt){
                  excpt.printStackTrace(System.out);
               }finally{
                  System.out.println("Created Singleton2 instance: " + singleInstance);
               }
            }
         }
      }
	  return singleInstance;
	}
}
