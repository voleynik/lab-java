package lab.codility.pairs;

import java.security.InvalidParameterException;

import org.junit.Assert;

import lab.codility.Util;

public class Pairs {

	public static int[] process(int[] arrInput){
				
		if(arrInput == null || arrInput.length < 1){
			throw new InvalidParameterException("Invalid array");
		}
		Util.print(arrInput, "", 0);
		
		int arrLen= arrInput.length;
		int[] arrReg = fillZeros(new int[arrLen]);
		int counter = 0;
		
		for (int i = 0; i < arrLen - 1; i++) {
			if(arrReg[i] == 1){
				continue;
			}
			
			int value = arrInput[i];
			int index = i;
			
			for (int j = ( i + 1); j < arrLen; j++) {
				int candidate = arrInput[j];
				int candidateIndex = j;
				if (arrReg[candidateIndex] != 1 && value == candidate) {
					arrReg[index] = 1;
					arrReg[candidateIndex] = 1;
					counter = counter + 2;
				}		
			}	
		}
		
		int[] arrResult = new int[arrLen - counter];
		int resCounter = 0;
		
		for (int k = 0; k < arrReg.length; k++) {
			int lonelyIndex = k;
			if(arrReg[k] == 0){
				arrResult[resCounter] = arrInput[lonelyIndex];
				resCounter++;
			}
		}
		
		return arrResult;
	}
	
	public static void main(String[] args){
		// 1 - only 7
		int[] inp1 = {9, 3, 6, 3, 7, 6, 9};
		int[] exp1 = {7};	
		int[] act1 = Pairs.process(inp1);
		Assert.assertArrayEquals("Test 1 FAILED - ", exp1, act1);
		// 2 - one element
		int[] inp2 = {0};
		int[] exp2 = {0};	
		int[] act2 = Pairs.process(inp2);
		Assert.assertArrayEquals("Test 2 FAILED - ", exp2, act2);
		// 3 - no uppaired
		int[] inp3 = {9, 3, 6, 3, 7, 6, 9, 7};
		int[] exp3 = new int[0];	
		int[] act3 = Pairs.process(inp3);
		Assert.assertArrayEquals("Test 3 FAILED - ", exp3, act3);
		// 4 - empty array
		int[] inp4 = new int[0];
		String msg4 = "Invalid array";
		try {
			int[] act4 = Pairs.process(inp4);
		} catch (Exception e) {
			Assert.assertSame("Test 4 FAILED - ", msg4, e.getMessage());
		}
		// 5 - null array
		int[] inp5 = null;
		String msg5 = "Invalid array";
		try {
			int[] act5 = Pairs.process(inp5);
		} catch (Exception e) {
			Assert.assertSame("Test 5 FAILED - ", msg5, e.getMessage());
		}	
	}
	
	public static int[] fillZeros(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		return arr;
	}
}
