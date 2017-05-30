package lab.poc.bit;

class BitDemo {
	public static void main(String[] args) {
		
		int bitmask = 0x000F;
		System.out.println("bitmask: " + bitmask); // dec 15, bin 00001111
		
		int val = 0x2222;
		System.out.println("val: " + val); // dec 8738, bin 0010001000100010
		
		System.out.println(val & bitmask); // prints "2"
	}
}
