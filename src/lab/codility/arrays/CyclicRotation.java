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
/*
A zero-indexed array A consisting of N integers is given. 
Rotation of the array means that each element is shifted right by one index, 
and the last element of the array is moved to the first place. 
For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] 
(elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Write a function:

class Solution { public int[] solution(int[] A, int K); }
that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
*/