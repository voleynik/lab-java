package lab.pzl;

public class ReverseBySwapping {

	public static void main(String[] args) {
		
		int[] a1 = new int[]{ 1, 2, 3, 4, 5, 6 };
		int temp = 0;
		
		for ( int i = a1.length - 1; i >= 0; i-- ) {
			for (int j = 0; j < i; j++) {
				temp = a1[j];
				a1[j] = a1[ j + 1 ];
				a1[ j + 1 ] = temp;
			}
		}
		System.out.println("End.");
	}
}
