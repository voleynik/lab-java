package lab.codility.timecomplexity;

class PermMissingElem {

	public int solution(int[] A){

		java.util.Arrays.sort(A);
		
		for (int i = 0; i < A.length; i++) {
				
			if(A[i + 1] - A[i] > 1){
				return A[i] + 1;
			}
		}

		return -1;
	}
	
	public static void main(String[] args) {
		
		PermMissingElem sol = new PermMissingElem();
		
		int[] input1 = {3,4,1,2,8,6,5,9};// 7
		int missing = sol.solution(input1);
		System.out.println("missing " + missing);
		
		int[] input2 = {8,7,6,5,3,2,1};// 4
		missing = sol.solution(input2);
		System.out.println("missing " + missing);
		
		int[] input3 = {4,9,5,7,8,10};// 6
		missing = sol.solution(input3);
		System.out.println("missing " + missing);
	}
}
/*
A zero-indexed array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }
that, given a zero-indexed array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
*/