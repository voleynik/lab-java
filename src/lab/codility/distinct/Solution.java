package lab.codility.distinct;

import java.util.Arrays;

class Solution {

	public int solution(int[] a){

		Arrays.sort(a);
		int count = 1;
		
		for (int i = 0; i < a.length - 1; i++) {
			if(a[i] == a[i + 1]){
				if(count != 0){
					count--;
				}
			}else{
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int result = -1;
		
		int[] input1 = {2, 2, 1, 3, 1, 1};// 1
		result = s.solution(input1);
		System.out.println("Distinct " + result);	
		
		int[] input2 = {2, 2, 1, 3, 1, 4};// 2
		result = s.solution(input2);
		System.out.println("Distinct " + result);
		
		int[] input3 = {2, 2, 1, 3, 1, 1, 4, 4, 5, 10};// 3
		result = s.solution(input3);
		System.out.println("Distinct " + result);
		
		int[] input4 = {2, 2, 1, 3, 1, 1, 4, 4, 3, 3};// 0
		result = s.solution(input4);
		System.out.println("Distinct " + result);
	}
}