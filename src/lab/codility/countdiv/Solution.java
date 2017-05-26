package lab.codility.countdiv;

import java.util.Arrays;

class Solution {

	public int solution(int a, int b, int k){

		int current = a;
		int count = 0;
		
		while (current <= b) {
			if(current % k == 0){
				count++;
			}
			current++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int result = s.solution(6, 11, 2);// 3
		System.out.println("CountDiv " + result);
		
		result = s.solution(6, 11, 3);// 2
		System.out.println("CountDiv " + result);
		
		result = s.solution(6, 11, 4);// 1
		System.out.println("CountDiv " + result);
	}
}