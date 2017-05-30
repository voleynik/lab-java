package lab.poc.rename;
import java.io.File;
public class CdRename { 

	public static void main(String[] args) {
		
		final String[] folders = { 
			  				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
			  				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20" 
			  			 };
		
		if(args.length < 1 || args[0] == null || args[0].length() < 1){
			System.out.println("Please provide folder name. Ex: D:\\Mp3\\Books\\DeekapChopra_BodyMind");
			System.exit(1);
		}
		String bookFolderPath = args[0];
		//~~~Check folder.
		File aFile = new File(bookFolderPath);
		if(aFile == null || ! aFile.canRead() || ! aFile.isDirectory()){
			System.out.println("Invalid folder name: " + bookFolderPath);
			System.exit(1);
		}
		//~~~ Check if folder contains any files.
		File[] cdFolders = aFile.listFiles();
		if(cdFolders == null || cdFolders.length < 1){
			System.out.println("Folder " + bookFolderPath + " is empty.");
			System.exit(1);
		}
		//~~~ Check if atleast 01 is present
		if( ! cdFolders[0].getName().equals("01") || ! cdFolders[0].isDirectory()){
			System.out.println("Folder contains invalid folder " + cdFolders);
			System.exit(1);
		}
		//~~~ Process folders 01, 02, 03...
		File myFolder = null;
		for ( int i = 0; i < cdFolders.length; i++ ) {
			String cdFolderName = cdFolders[i].getName();
			if( folders.length >= cdFolders.length && cdFolderName.equals(folders[i]) ){
				File[] mp3files = cdFolders[i].listFiles();
				for (int j = 0; j < mp3files.length; j++) {
					mp3files[j].renameTo( new File(bookFolderPath + "\\" + folders[i] + mp3files[j].getName()));
		
				}
				cdFolders[i].delete();
			}
		}
	}
}
/*
&& myFolderName.substring( myFolderName.length() - 2, 2 ).equals(folders[i]) ){
*/







