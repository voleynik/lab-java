package lab.codility.countingelements;

import java.util.Iterator;

class MaxCounters {

	public int[] solution(int N, int[] A){
		
		int[] counters = new int[N];
		int countMax = 0;
		
		for (int i = 0; i < A.length; i++) {
			if(A[i] >= 1 && A[i] <= N){
				counters[A[i] - 1] = counters[A[i] - 1] + 1;
				if(counters[A[i] - 1] > countMax){
					countMax = counters[A[i] - 1];
				}
			}else if (A[i] == (N + 1)){
				for (int j = 0; j < counters.length; j++) {
					counters[j] = countMax;					
				}
			}
		}

		return counters;
	}
	
	public static void main(String[] args) {
		
		MaxCounters sol = new MaxCounters();
		
		int[] input1 = {3, 4, 4, 6, 1, 4, 4};
		int[] res1 = sol.solution(5, input1);
		System.out.println("res: " + res1);//5
	}
}