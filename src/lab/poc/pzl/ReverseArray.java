package lab.pzl;

public class ReverseArray {

	public static void main(String[] args) {
		
		char[] a1 = new char[]{ 'a', 'b', 'c', 'd' };
		char[] a2 = new char[ a1.length ];
		
		for( int i = 0; i < a1.length; i++ ){
			a2[ a1.length - ( i + 1 ) ] = a1[i];
			System.out.println("a2[" + (a1.length - (i + 1)) + "]: " + a2[a1.length - (i + 1) ]);
		}
	}
}
