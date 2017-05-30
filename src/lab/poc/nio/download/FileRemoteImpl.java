package lab.poc.nio.download;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
/*
Class FileRemoteImpl - This is the implementation class that implements all 
the methods declared in the remote interface.
Fields:
name - Stores the name. 
fi - Represents the object of FileInfo class.
Methods:
downloadFile() - This method is called when the end user clicks the window close button.
displayList() - This method is invoked when an end user selects any command from the menu bar.
*/
public class FileRemoteImpl extends UnicastRemoteObject implements FileRemote 
{
	private static final long serialVersionUID = 0;
   private String name;
   public FileInfo fi;
   /* Defines default constructor. */
   public FileRemoteImpl(String str) throws RemoteException
   {
      super();
      name = str;
      }
      /*
      downloadFile() - Defines the downloadFile() method.
      Parameter: filename - Represents the name of the file.
      Return Value: bufferFile[] - Represents the byte array that contains the file data.
      */
         public byte[] downloadFile(String filename)
      {
         /* Declares object of FileInputStream class. */            
         FileInputStream fin;
         /* Declares object of FileChannel class. */
         FileChannel fchan;
         /* Declares object of ByteBuffer class. */
         ByteBuffer buff;
         long fsize;
         String str;         
         byte bufferFile[] = null;
         try 
         {
            /* Creates instance of FileInputStream class. */
            fin = new FileInputStream(filename);
            /* Gets the channel from file input stream. */
            fchan = fin.getChannel();
            /* Retrieves the size of the file channel. */
            fsize = fchan.size();
            /* Allocates the size of byte buffer. */
            buff = ByteBuffer.allocate((int)fsize);
            /* Reads the file from the channel to buffer. */
            fchan.read(buff);
            /* Rewinds the buffer. */
            buff.rewind();
            /* Creates a byte buffer of size equals to the file size. */
            bufferFile = new byte[(int)fsize];
            for(int i=0; i<(int)fsize; i++)
            {
               /* Stores the data into a byte array. */
               bufferFile[i] = buff.get();
            }
         } 
         catch(Exception e)
         {
            System.out.println("Error: " + e);
          }
         /* Returns the byte array. */
         return(bufferFile);
      }
   /*
   displayList() - Defines the displayList() method.
   Parameter: NA
   Return Value: v - Represents a vector that contains the list of files and their details.
   */
   public Vector displayList() throws RemoteException
   {
      /* 
      Creates and initializes the object of the Vector class. 
      */
      Vector v = new Vector();
      /* Creates objects of the String class. */
      String SNo = "";
      String fileName = "";
      String size = "";
      /* Creates an object of the String array. */
      String files[] = null;
      int count =1;
      try
      {
         /* Creates and initialize the object of the File class. */
//         File folder = new File("C:/CodeBook/NIO/FileTransfer/Server");
        File folder = new File("K:/a1/projects-a1/lab/labUtil/java/lab/nio/download");
         
         /* Stores the list of files in the string array. */
         files = folder.list();
         for (int i=0; i<files.length; i++)
         {
            /* Creates and initialize the object of the File class. */
            File file = new File(folder.getAbsolutePath() + File.separator + files[i]);
            /* 
            Checks whether the file object is a File type or a Directory type. 
            */
            if (file.isFile())
            {
               /* Stores the serial number. */
               SNo = String.valueOf((count));
               /* Stores the file name. */
               fileName = file.getName();
               /* Stores the file size. */
               size = String.valueOf(file.length());
               /* Initializes the object of the FileInfo class. */
               fi = new FileInfo(SNo, fileName, size);
               /* 
               Adds the object of the FileInfo class at the end of the vector. 
               */
               v.addElement(fi);
               /* Increments the counter by 1. */
               count++;
            }            
         }         
      }
      catch(Exception e)
      {
         e.printStackTrace();
         System.out.println("Error! " + e);
      }
/* Returns the vector. */
      return v;
   }   
}