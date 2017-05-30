package lab.sortpackage;

public class SelectionShiftSort {

	public static void sort(int[] arr) {
		
		printNumbers(arr, 0);
		
		int n = arr.length;// array length
		
		for(int lastToShift = 0; lastToShift < n - 1; lastToShift++){
			int minElementIndex = findMinimum(arr, lastToShift);		
			int minElementValue = arr[minElementIndex];
			arr = shiftNumbers(arr, lastToShift, minElementIndex);
			arr[lastToShift] = minElementValue;
			printNumbers(arr, lastToShift + 1);
		}			
	}
	
	private static int[] shiftNumbers(int[] arr, int lastToShift, int minElementIndex){
		for(int j = minElementIndex; j > 0; j--){
			if(lastToShift < j){
				arr[j] = arr[j - 1];							
			}	
		}
		return arr;
	}
		
	private static int findMinimum(int[] arr, int i){//.
		int minElementIndex = i;	
		for(int j = i; j < arr.length; j++){
			if(j < (arr.length - 1) && arr[minElementIndex] > arr[j + 1]){
				minElementIndex = j + 1;
			}		
		}
		return minElementIndex;
	}

	private static void printNumbers(int[] input, int shiftNumber) {
		for (int i = 0; i < input.length; i++) {
			if(i != 0) System.out.print(", ");
			System.out.print(input[i]);
		}
		if(shiftNumber < 1){
			System.out.println(" - Unsorted array ~~~~~~~~~~~");
		}else{
			System.out.println(" - shiftNumber # " + shiftNumber);	
		}
	}

	public static void main(String[] args) {
		int[] arr = { 8, 7, 0, 5, 4, 3, 2, 1, 6 };
		sort(arr);
		System.out.println("The end");
	}
}