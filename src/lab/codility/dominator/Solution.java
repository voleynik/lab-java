package lab.codility.dominator;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution {

	public int[] solution(int[] arr1){
		
		int[] arr2 = arr1;
		Arrays.sort(arr2);		
		int count = -1;
		
		TreeMap tm = new TreeMap();
		
		
		for (int i = 0; i < arr2.length; i++) {
			
		}
		
		return null;
	}
	
	public static void main(String[] args) {		
		Solution sol = new Solution();
		
		int[] input1 = {3, 4, 3, 2, 3, -1, 3, 3};
		int[] result = sol.solution(input1);// 0 2 4 6 7
		
		System.out.println("End");
	}
}
