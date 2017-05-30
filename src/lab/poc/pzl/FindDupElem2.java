package lab.poc.pzl;

//~~~ Find duplicate elements.
public class FindDupElem2 {

	public static void main(String[] args) {
		
		int[] a1 = new int[]{ 1,4,3,4,5,6,7,4,9 };
		int[] temp = null;
		
		for ( int i = 0; i < a1.length; i++ ) {
			temp = new int[ a1.length - i ];
			System.arraycopy( a1, i, temp, 0, a1.length - i );
			for ( int j = 1; j < temp.length; j++ ) {
				if( temp[0] == temp[j]){
					System.out.println(
						"a1[" + ( a1.length - temp.length ) + "]: " +
						temp[0] + " = " +
						"a1[" + ( a1.length - temp.length + j ) + "]: " +
						temp[j]);
				}	
			}		
		}
	}
}
