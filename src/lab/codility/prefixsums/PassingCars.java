package lab.codility.prefixsums;


class PassingCars {// NEXT

	public int solution(int A, int B, int K){
			
		int intCount = 0;
		for (int i = A; i <= B; i++) {
			if((i % K) == 0){
				intCount += 1;
			}
		}

		return intCount;
	}
	
	public static void main(String[] args) {
		
		PassingCars sol = new PassingCars();
		
		int res1 = sol.solution(6, 11, 2);
		System.out.println("perm: " + res1);//
	}
}