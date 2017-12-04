package lab.codility.countingelements;

import java.util.Arrays;

class PermCheck {

	public int solution(int[] A){
		
		java.util.Arrays.sort(A);
		
		for (int i = 0; i < A.length - 1; i++) {
			if((A[i + 1] - A[i]) != 1){
				return 0;
			}	
		}

		return 1;
	}
//given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.	
	public static void main(String[] args) {
		
		PermCheck sol = new PermCheck();
		
		int[] input1 = {1,2,3,4,5,6,7,8};
		int res = sol.solution(input1);
		System.out.println("perm: " + res);// 1=true
		
		int[] input2 = {7,2,6,4,5,3,1,8};
		res = sol.solution(input2);
		System.out.println("perm: " + res);// 1=true
		
		int[] input3 = {7,2,6,9,5,3,1,8};
		res = sol.solution(input3);
		System.out.println("perm: " + res);// 1=false
	}
}