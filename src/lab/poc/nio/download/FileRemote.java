package lab.nio.download;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;
/*
Interface FileRemote - This interface declares the remote methods.
Methods:
downloadFile() - Downloads the file from a remote location.
displayList() - Displays the list of files stored in the server to the client.
*/
public interface FileRemote extends Remote 
{
   /* Declares downloadFile() method. */
   public byte[] downloadFile(String filename) throws RemoteException;
   /* Declares displayList() method. */
   public Vector displayList() throws RemoteException;
}