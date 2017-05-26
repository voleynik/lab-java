package lab.codility.frog;

import java.util.Arrays;

class Solution {

	public int solution(int x, int y, int d){

		int position = x;
		int jumpCounter = 0;
		
		while (position < y) {
			jumpCounter++;
			position = position + d;
		}

		return jumpCounter;
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		
		int x = 10, y = 85, d = 30; 
		int result = s.solution(x, y, d);
		System.out.println("jumpCounter " + result);
	}
}