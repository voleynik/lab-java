package lab.poc.bit;

/**
 * 
 */
public class IntBitArray {
	private int bitArray;
	
	public void set(int bitNumber, byte bitValue){
		
	}
	
	public byte get(int bitNumber){
		int myInt = 0;
		myInt = bitArray << (31 - bitNumber);
		myInt = myInt >> 31;
		return (byte)myInt;
	}
	
	public void printIntegerBits(){
		int flag = 0;
		for(int i = 0; i < 32; i++){
			if(flag == 0){
				flag++;
			}else{
				flag = flag * 2;
			}
			if((bitArray & flag) == flag){
				System.out.println("bit " + i + " = 1");
			}else{
				System.out.println("bit " + i + " = 0");
			}
		}
	}
	
	public static void main(String[] args){

		IntBitArray ba = new IntBitArray();
		ba.bitArray = 1023;
		ba.printIntegerBits();//OK
		
		System.out.println("Value of bit " + 8 + " is " + ba.get(8));
		System.out.println("Value of bit " + 9 + " is " + ba.get(9));
		System.out.println("Value of bit " + 10 + " is " + ba.get(10));
		System.out.println("Value of bit " + 11 + " is " + ba.get(11));
	}
}
