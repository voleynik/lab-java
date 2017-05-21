package lab.binarygap;

class Solution {

	public static void main(String[] args) {//*
		
		Solution sol = new Solution();//*
		
		int
		maxGapSize = sol.solution(9);// 2
		maxGapSize = sol.solution(529);// 4
		maxGapSize = sol.solution(20);// 1
		maxGapSize = sol.solution(15);// 0
		maxGapSize = sol.solution(375);// 1
		maxGapSize = sol.solution(999);// 2
		maxGapSize = sol.solution(1041);// 3
	}
	
	public int solution(int input){//*
		
		String strBin = Integer.toBinaryString(input);
		
		//System.out.print("Array: " + strBin);
		
		char[] arrBin = strBin.toCharArray();
		int maxGapSize = 0;
		int gapSize = 0;
		
		for (int i = 0; i < arrBin.length; i++) {
			
			String strBit = String.valueOf(arrBin[i]);
			if (strBit.equals("0")) {
				gapSize++;
			}else{
				if(gapSize > 0 && gapSize > maxGapSize){
					maxGapSize = gapSize;
					gapSize = 0;
				}
			}			
		}
		
		//System.out.println(" - maxGapSize: " + maxGapSize);

		return maxGapSize;
	}
}