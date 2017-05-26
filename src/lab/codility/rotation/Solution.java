package lab.codility.rotation;

import java.security.InvalidParameterException;
import java.util.Arrays;

import lab.codility.Util;

public class Solution {

	public int[] solution(int[] arrInput, int k){// {9, 3, 9, 3, 9, 9, 7};
		
		if(arrInput == null || arrInput.length < 1){
			throw new InvalidParameterException();
		}
		
		int[] left = Arrays.copyOfRange(arrInput, arrInput.length - k, arrInput.length);
		int[] right = Arrays.copyOfRange(arrInput, 0, arrInput.length - k);		
		System.arraycopy(left, 	0, arrInput, 0, 			left.length);
		System.arraycopy(right, 0, arrInput, left.length, 	right.length);
		
		return arrInput;	
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr1 = {0, 1, 2, 3, 4, 5, 6};
		Util.print(arr1, " Before", 0);
		int[] result = sol.solution(arr1, 1);
		Util.print(result, " After", 0);
		
		int[] arr2 = {0, 1, 2, 3, 4, 5, 6};
		Util.print(arr2, " Before", 0);
		result = sol.solution(arr2, 2);
		Util.print(result, " After", 0);
		
		int[] arr3 = {0, 1, 2, 3, 4, 5, 6};
		Util.print(arr3, " Before", 0);
		result = sol.solution(arr3, 3);
		Util.print(result, " After", 0);
	}
}