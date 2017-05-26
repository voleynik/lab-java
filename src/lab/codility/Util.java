package lab.codility;

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
}
