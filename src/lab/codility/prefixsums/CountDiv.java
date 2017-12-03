package lab.codility.prefixsums;


class CountDiv {

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
		
		CountDiv sol = new CountDiv();
		
		int res1 = sol.solution(6, 11, 2);
		System.out.println("perm: " + res1);//
	}
}