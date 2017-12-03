package lab.codility.timecomplexity;

class TapeEquilibrium {

	public int solution(int[] A){

		int minDiff = Integer.MAX_VALUE;
		int diff = -1;
		
		for (int p = 1; p < A.length; p++) {
				
			int leftSum = 0;
			for(int i = 0; i < p; i++){
				leftSum = leftSum + A[i];
			}
			
			int rightSum = 0;
			for(int i = p; i < A.length; i++){
				rightSum = rightSum + A[i];
			}
			
			diff = java.lang.Math.abs(leftSum - rightSum);
			if(diff < minDiff){
				minDiff = diff;
			}
			
		}

		return minDiff;
	}
	
	public static void main(String[] args) {
		
		TapeEquilibrium sol = new TapeEquilibrium();
		
		int[] input1 = {3,1,2,4,3};
		int minDiff = sol.solution(input1);
		System.out.println("minDiff: " + minDiff);

	}
}