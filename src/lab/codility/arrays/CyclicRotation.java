package lab.codility.arrays;

import lab.codility.Util;

public class CyclicRotation {

	public int[] solution(int[] A, int K){
		
		int[] left = java.util.Arrays.copyOfRange(A, A.length - K, A.length);
		int[] right = java.util.Arrays.copyOfRange(A, 0, A.length - K);		
		System.arraycopy(left, 	0, A, 0, 			left.length);
		System.arraycopy(right, 0, A, left.length, 	right.length);
		
		return A;	
	}
	
	public static void main(String[] args) {
		CyclicRotation sol = new CyclicRotation();
		
		int[] arr1 = {0, 1, 2, 3, 4, 5, 6};
		Util.print(arr1, " Before", 0);
		int[] result = sol.solution(arr1, 1);
		Util.print(result, " After", 0);
		
		int[] arr2 = {0, 1, 2, 3, 4, 5, 6};
		Util.print(arr2, " Before", 0);
		result = sol.solution(arr2, 2);
		Util.print(result, " After", 0);
		
		int[] arr3 = {0, 1, 2, 3, 4, 5, 6};
		Util.print(arr3, " Before", 0);
		result = sol.solution(arr3, 3);
		Util.print(result, " After", 0);
	}
}