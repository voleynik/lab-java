package lab.codility.countingelements;

class FrogRiverOne {

	public int solution(int[] A){
		
		java.util.Arrays.sort(A);
		
		for (int i = 0; i < A.length - 1; i++) {
			if((A[i + 1] - A[i]) != 1){
				return 0;
			}	
		}

		return 1;
	}
	
	public static void main(String[] args) {
		
		FrogRiverOne sol = new FrogRiverOne();
		
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