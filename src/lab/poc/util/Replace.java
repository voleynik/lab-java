package lab.poc.util;

public class Replace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "This is a text to demonstrate replacing underscore with blanks.";
		System.out.println("1. " + s1);
		//StringBuffer sb = new StringBuffer(myString);
		
		s1 = s1.replaceAll(" ", "_");
		System.out.println("2. " + s1);
		
		s1 = s1.replaceAll("_", " ");
		System.out.println("3. " + s1);
	}
}
