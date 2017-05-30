package lab.poc.bit;

public class BitUtil {
	
	public static int getBit(int a, int i){
		int b = a << (31 - i);
		return b >>> 31;
	}
	
	public static int setBit(int a, int i, boolean v){ 
		int b = getBit(a, i);
		if((b == 0 && v == false) || (b == 1 && v == true)){
			return a;
		}
		int tempInt = 1;
		for(int j = 0; j < i; j++){
			tempInt *= 2;
		}
		if(b == 0 && v == true){
			a += tempInt;
		}
		if(b == 1 && v == false){
			a -= tempInt;
		}
		return a;
	}
	
	
	public static void main(String[] args){
				
		System.out.println("Testing getBit()...");
		int testArray = 16;
		System.out.println("testArray = " + testArray + ", binary value: 00000000000000000000000000010000");		
		System.out.println("Bit " + 0 + " = " + getBit(testArray, 0));
		System.out.println("Bit " + 1 + " = " + getBit(testArray, 1));
		System.out.println("Bit " + 2 + " = " + getBit(testArray, 2));
		System.out.println("Bit " + 3 + " = " + getBit(testArray, 3));
		System.out.println("Bit " + 4 + " = " + getBit(testArray, 4));
		System.out.println("Bit " + 5 + " = " + getBit(testArray, 5));
		System.out.println("Bit " + 6 + " = " + getBit(testArray, 6));

		System.out.println();
		System.out.println("Testing setBit()...");
		System.out.println("BEFORE - Bit 3: " + getBit(testArray, 3));
		System.out.println("AFTER - Bit 3: " + getBit(setBit(testArray, 3, true), 3));
	}
}
