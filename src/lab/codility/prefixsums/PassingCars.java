package lab.codility.prefixsums;

class PassingCars {

	public int solution(int[] A){
			
		int passCount = 0;
		int start = A[0];
		for (int i = 0; i < A.length - 1; i++) {
			if(A[i] == start){
				for(int j = i + 1; j < A.length; j++){
					if(A[j] != start){
						passCount ++;
						if(passCount > 1000000000){
							return -1;
						}
					}
				}
			}	
		}

		return passCount;
	}
	
	public static void main(String[] args) {
		
		PassingCars sol = new PassingCars();
		
		int[] A3 = {1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0};
		int res = sol.solution(A3);
		System.out.println("res: " + res);
		
		int[] A2 = {1,0,1,0,0};
		res = sol.solution(A2);
		System.out.println("res: " + res);
		
		int[] A1 = {0,1,0,1,1};
		res = sol.solution(A1);
		System.out.println("res: " + res);
	}
}