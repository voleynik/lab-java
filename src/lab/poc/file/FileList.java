package lab.poc.file;

import java.io.File;

import lab.poc.util.IConstant;

public class FileList{
  
  public static final String filePath = "C:/projects/tsa/etc";
  
  public static void main(String[] args){
    try {
      processFile(new File(filePath), 0);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  public static void processFile(File pFile, int offSet) throws Exception {
    offSet++;
    if(pFile.isDirectory()){
      processFolder(pFile, offSet);       
    }else{
      System.out.println(indent(offSet) + pFile.getPath());
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static void processFolder(File pFolder, int offSet) throws Exception {
    System.out.println(indent(offSet) + pFolder.getPath());
    File[] folderItems = pFolder.listFiles();
    for( int i = 0; i < folderItems.length; i++){
      processFile(folderItems[i], offSet);
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  private static String indent(int offSet){
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < offSet; i++){  
      sb.append(IConstant.oneSpace);
    }
    return sb.toString();
  }
}
/* NOTES

System.out.println("AbsolutePath:  " + aFile.getAbsolutePath()); //~ Same as Path
System.out.println("CanonicalPath: " + aFile.getCanonicalPath()); //~ Same as Path

*/