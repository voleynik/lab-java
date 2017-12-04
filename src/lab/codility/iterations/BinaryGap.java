package lab.codility.iterations;

class BinaryGap {

	public static void main(String[] args) {//*
		
		BinaryGap sol = new BinaryGap();
		
		int
		maxGapSize = sol.solution(9);// 2
		maxGapSize = sol.solution(529);// 4
		maxGapSize = sol.solution(20);// 1
		maxGapSize = sol.solution(15);// 0
		maxGapSize = sol.solution(375);// 1
		maxGapSize = sol.solution(999);// 2
		maxGapSize = sol.solution(1041);// 5
	}
	
	public int solution(int input){//*
		
		String strBin = Integer.toBinaryString(input);
		
		System.out.print("int: " + input + ", Array: " + strBin);
		
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
		
		System.out.println(" - maxGapSize: " + maxGapSize);

		return maxGapSize;
	}
}
/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded 
by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. 
The number 529 has binary representation 1000010001 and contains two binary gaps: 
one of length 4 and one of length 3. The number 20 has binary representation 10100 and 
contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps.

Write a function:
class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. 
The function should return 0 if N doesn't contain a binary gap.
For example, given N = 1041 the function should return 5, 
because N has binary representation 10000010001 and so its longest binary gap is of length 5.
Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
*/