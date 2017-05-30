package lab.poc.file;
import java.io.File;

/*
 * Parms: fileFolder filePrefix
 * 
 */
public class PrefixFile {

	static File fileFolder;
	static File[] allFiles;
	
	public static void main(String[] args) {
//		fileFolder = new File(args[0]);
//		System.out.println(args[0] + " is a folder: " + fileFolder.isDirectory());
//		allFiles = fileFolder.listFiles();
//		printFileList(allFiles);
		renameAllFiles(args);
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static void renameAllFiles(String[] args){
		File newFile = null;
		fileFolder = new File(args[0]);
		allFiles = fileFolder.listFiles();
		for (int i = 0; i < allFiles.length; i++) {
			newFile = new File(args[0] + "\\" + args[1] + allFiles[i].getName());
			allFiles[i].renameTo(newFile);
		}	
	}

	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//	private static void printFileList(File[] pFiles){
//		for (int i = 0; i < pFiles.length; i++) {
//			System.out.println("#" + (i + 1) + " " + pFiles[i].getPath());
//		}
//		
//	}
}
