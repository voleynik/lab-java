package lab.poc.nio.download;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
/*
class FileServer - Creates the RMI server that registers all the remote objects.
Method:
main() - Starts the RMI server and registers the remote objects. */  
public class FileServer 
{
   public static void main(String args[]) 
   {
      /* Sets the RMI security manager. */               
      System.setSecurityManager(new RMISecurityManager());
      try 
      {
         /* Creates the remote object. */    
         FileRemote f = new FileRemoteImpl("FServer");
         /* Binds the remote object to the RMI registry. */
         Naming.rebind("FServer", f);
         System.out.println("Object is registered.");
         System.out.println("Now server is waiting for client request");
        }
      catch(Exception e) 
      {
        e.printStackTrace();
        System.out.println("FileServer: " + e);
      }
   }
}