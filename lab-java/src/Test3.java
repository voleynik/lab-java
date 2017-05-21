public class Test3 {

	public int solution(int input){
		
		String strBin = Integer.toBinaryString(input);
		
		System.out.print("input " + input + ", array: " + strBin);
		
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
	
	public static void main(String[] args) {
		
		Test3 s = new Test3();
		
		int
		maxGapSize = s.solution(9);// 2
		maxGapSize = s.solution(529);// 4
		maxGapSize = s.solution(20);// 1
		maxGapSize = s.solution(15);// 0
		maxGapSize = s.solution(375);// 1
		maxGapSize = s.solution(999);// 2
		maxGapSize = s.solution(1041);// 3
	}
}
