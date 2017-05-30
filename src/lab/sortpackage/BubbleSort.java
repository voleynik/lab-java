package lab.sortpackage;

public class BubbleSort {

	public static void sort(int array[]) {
		printNumbers(array, 0);//	 print original unsorted array
		int n = array.length;// array length
		for (int i = 0; i < n - 1; i++) {// outer loop i <----- n - 1
			int next = 0;//	 next element
			int numberOfSwaps = 0;
			for (int prev = 0; prev < n - 1; prev++) {// inner loop j <----- n - 1
				next = prev + 1;
				if (array[prev] > array[next]) {
					swapNumbers(prev, next, array);
					numberOfSwaps++;
				}
			}
			if(numberOfSwaps < 1) break;
			printNumbers(array, i + 1);
		}	
	}

	private static void swapNumbers(int prev, int next, int[] array) {
		int temp;
		temp = array[prev];//	 move current to temp
		array[prev] = array[next];//	 move next to previous
		array[next] = temp;
	}

	private static void printNumbers(int[] input, int swapNumber) {
		for (int i = 0; i < input.length; i++) {
			if(i != 0) System.out.print(", ");
			System.out.print(input[i]);
		}
		if(swapNumber < 1){
			System.out.println(" - unsorted array ~~~~~~~~~~~");
		}else{
			System.out.println(" - swapNumber # " + swapNumber);	
		}
	}

	public static void main(String[] args) {
		int[] input1 = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		sort(input1);
		int[] input2 = { 1, 2, 9, 8, 7, 6, 5, 4, 3 };
		sort(input2);
		System.out.println("The end");
	}
}