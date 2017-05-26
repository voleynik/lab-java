package lab;
public class Solution {

	public int solution(int[] ar){
		
		int max  = -1;
		
		for (int p = 0; p < ar.length - 2; p++) {				
			for(int q = p + 1; q < ar.length - 1; q++){
				for(int r = q + 1; r < ar.length; r++){
					System.out.println("p: " + p + ", q: " + q + ", r: " + r);
					if(0 <= p && p < q && q < r && r < ar.length && 
							(ar[p] + ar[q]) > ar[r] && (ar[q] + ar[r]) >  ar[p] && (ar[r] + ar[p] > ar[q])){
						int maxTemp = ar[p] + ar[q] + ar[r];
						if(maxTemp > max){
							max = maxTemp;
						}		
					}
				}
			}
		}

		return max;
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int max = -1;
		
		int[] ar1 = {10, 2, 5, 1, 8, 20};
		max = s.solution(ar1);
		System.out.println("max: " + max);
	}
}