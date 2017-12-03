package lab.codility.countingelements;

import java.util.Iterator;

class MissingInteger {

	public int solution(int[] A){
		
		java.util.Arrays.sort(A);
		
		int res = 0;
		
		for (int i = 0; i < A.length - 1; i++) {
			
			if(A[i + 1 ] == A[i]){
				continue;
			}else if (A[i + 1] - A[i] > 1){
				res = A[i] + 1;
				break;
			}		
		}
		
		if(res < 0){
			res = 1;
		}else if(res == 0){
			res = A[A.length - 1] + 1;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		
		MissingInteger sol = new MissingInteger();
		
		int[] input1 = {1, 3, 6, 4, 1, 2};
		int res1 = sol.solution(input1);
		System.out.println("res: " + res1);//5
		
		int[] input2 = {1, 2, 3};
		int res2 = sol.solution(input2);
		System.out.println("res: " + res2);//4
		
		int[] input3 = {-1, -3};
		int res3 = sol.solution(input3);
		System.out.println("res: " + res3);//1
	}
}