package lab.poc.property;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GBox {
	
	private final static String s1 = "C:\\BadWords.txt";
	private final static String s2 = "C:\\BadSentence.txt";
	
	public static void main(String[] args) {
		
		List badWords = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(s1));
			String myStr;
	        while ((myStr = in.readLine()) != null) {
	        	badWords.add(myStr);
	        }
	        in.close();
		} catch (IOException e) {
			System.out.println("ERROR: Can't find file " + s1);
			System.exit(1);
		}
		
		
		List badSentences = new ArrayList();
		try {
			BufferedReader in = new BufferedReader(new FileReader(s2));
			String myStr;
	        while ((myStr = in.readLine()) != null) {
	        	badSentences.add(myStr);
	        }
	        in.close();
		} catch (IOException e) {
			System.out.println("ERROR: Can't find file " + s2);
			System.exit(1);
		}
		
		String sent = null;
		for ( int i = 0; i < badSentences.size(); i++) {		
			sent = replace((String) badSentences.get(i), badWords);
			System.out.println("Fixed sentence -> " + sent);
		}
	}
	
	private static String replace(String sent, List badWords){
		String bad = null;
		StringBuffer bs = null;
		for ( int i = 0; i < badWords.size(); i++) {			
			int j = sent.indexOf((String)badWords.get(i));		
			if(j != -1){
				bs = new StringBuffer (sent);
				bs.replace(j, j + ((String)badWords.get(i)).length(), "***");	
			}
		}
		return bs.toString();
	}
}
