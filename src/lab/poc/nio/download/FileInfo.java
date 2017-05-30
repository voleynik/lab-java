package lab.poc.nio.download;
import java.io.Serializable;
/*
class FileInfo - This class stores the file description, such as file index, file name, and file size.
Fields:
fileIndex - Contains the file name.
fileName - Contains the file path.
fileSize - Contains the file size.
*/
public class FileInfo implements Serializable
{
	private static final long serialVersionUID = 0;
   /* Declares the objects of String class. */
   String fileIndex;
   String fileName;
   String fileSize;
   /* Defines default constructors. */
   public FileInfo(String fileIndex, String fileName, String fileSize)
   {
      this.fileIndex = fileIndex;
      this.fileName = fileName;
      this.fileSize = fileSize;
   }
}