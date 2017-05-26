package lab;

public class Util {

	public static void print(int[] arr, String msg, int count) {
		
		for (int i = 0; i < arr.length; i++) {
			if(i != 0) System.out.print(", ");
			System.out.print(arr[i]);
		}
		
		if(count < 1){
			System.out.println(msg);
		}else{
			System.out.println(" - try # " + count);	
		}
	}
	
	public static int[] fillZeros(int[] arr){
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		return arr;
	}
	
	int[] arr1 = {1, 2, 3, 4, 5};
	int arrIndex = 0;
}
