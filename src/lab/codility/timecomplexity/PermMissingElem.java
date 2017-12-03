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