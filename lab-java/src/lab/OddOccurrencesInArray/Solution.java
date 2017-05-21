package lab.OddOccurrencesInArray;

import java.security.InvalidParameterException;

public class Solution {

	public int solution(int[] arrInput){// {9, 3, 9, 3, 9, 9, 7};
		
		if(arrInput == null || arrInput.length < 1){
			throw new InvalidParameterException();
		}
		int result = -1;
		boolean found = false;
		
		for (int i = 0; i < arrInput.length; i++) {			
			if(arrInput[i] == -1 ){
				continue;
			}	
			
			found = false;
					
			for (int j = i + 1; j < arrInput.length; j++) {
				if(arrInput[j] == -1 ){
					continue;
				}
				
				if(arrInput[i] == arrInput[j]){
					arrInput[i] = -1;
					arrInput[j] = -1;
					found = true;
					break;
				}
			}
			
			if( ! found){
				result = arrInput[i];
			}
		}
		
		return result;	
	}
	
	public static void main(String[] args) {
		Solution sol = new Solution();
		
		int[] arr1 = {9, 7, 9, 3, 9, 9, 3};
		int result = sol.solution(arr1);
		System.out.println("result: " + result);
	
		int[] arr2 = {9, 3, 9, 3, 9, 9, 7};
		int res2 = sol.solution(arr2);
		System.out.println("result: " + res2);
	
		int[] arr3 = {7, 9, 3, 9, 9, 3, 9};
		result = sol.solution(arr3);
		System.out.println("result: " + result);
		
		int[] arr4 = {9, 9, 9, 3, 9, 7, 3};
		result = sol.solution(arr4);
		System.out.println("result: " + result);
		
		int[] arr5 = {9, 9, 9, 9, 7, 3, 3};
		result = sol.solution(arr5);
		System.out.println("result: " + result);
	}
}
