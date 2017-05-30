package lab.pzl;

public class StrToInt {

	public static void main(String[] args) {
		String s = "1234507";
		int i = 0;
		for( int j = 0; j < s.length(); j++ ){
			i *= 10;
			i += getInt(s.charAt(j));
			System.out.println("i: " + i);
		}
		System.out.println("Final i: " + i);
	}
	
	private static int getInt(char c){
		int i = 0;
		switch(c){
			case '0': i = 0; break;
			case '1': i = 1; break;
			case '2': i = 2; break;
			case '3': i = 3; break; 
			case '4': i = 4; break;
			case '5': i = 5; break;
			case '6': i = 6; break;
			case '7': i = 7; break;
			case '8': i = 8; break;
			case '9': i = 9; break;			
		}
		return i;
	}
}
