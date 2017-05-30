package lab.poc.pzl;

public class TwoIntArrays {

	public static void main(String[] args) {

		int[] a1 = {1, 0, 3};
		int[] a2 = new int[ a1.length ];
		
		for ( int i = 0; i < a2.length; i++ ) {
			a2[i] = getEl( i, a1 );
			System.out.println("a2[" + i + "]: "  + a2[i] );
		}
	}
	
	private static int getEl( int i, int[] a1 ){
		int ctr = 0;
		int res = 0;
		for ( int j = 0; j < a1.length; j++ ) {
			if( j != i){
				if( a1[j] == 0 ){
					return 0;
				}
				if( ctr == 0 ){
					res = a1[j];
				}else{
					res *= a1[j];
				}
				ctr++;
			}		
		}
		return res;
	}
}
/*
1~ 1, 2, 3 -> 6, 3, 2 -> ok
*/
