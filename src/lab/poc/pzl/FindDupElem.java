package lab.poc.pzl;

import lab.poc.util.Util;

//~~~ Find duplicate elements.
public class FindDupElem {

	public static int[] a1 = new int[]{ 4, 4, 4, 4, 4, 4, 4, 4 };
	public static int[] dup = new int[ a1.length / 2 ];
	public static int   dupCtr = 0;
	
	public static void main(String[] args) {

		for ( int i = 0; i < ( a1.length - 1 ); i++ ) {

			for ( int j = (i + 1); j < ( a1.length ); j++ ) {
				
				if( isDup(a1[i])) break;
				
				if( a1[ i ] == a1[ j ] ){
					addToDup(a1[ j ]);
				}
			}		
		}
		printArray( dup );
	}
	
	private static void addToDup(int i){
		dup[dupCtr++] = i;
	}
	
	private static boolean isDup(int myInt){
		for(int i = 0; i < dupCtr; i++){
			if(myInt == dup[i])return true;
		}
		return false;
	}
	
	public static void printArray( int[] a ){
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i +"]: " + a[i]);
		}
	}
}
