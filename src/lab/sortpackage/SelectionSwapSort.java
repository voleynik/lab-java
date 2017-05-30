package lab.sortpackage;

public class SelectionSwapSort {

	public static void sort(int[] arr) {
		
		Util.print(arr, 0);
		
		int n = arr.length;// array length
		
		for(int i = 0; i < n - 1; i++){
			
			int iMin = i;
			
			for(int j = (i + 1); j < n; j++){
				if(arr[j] < arr[iMin]){
					iMin = j;
				}		
			}
			
			int temp = arr[i];
			arr[i] = arr[iMin];
			arr[iMin] = temp;
			
			Util.print(arr, i + 1);
		}			
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 0, 6, 2, 7, 5, 3};
		sort(arr);
		System.out.println("The end");
	}
	
	private static void printNumbers(int[] arr, int switchNumber) {
		for (int i = 0; i < arr.length; i++) {
			if(i != 0) System.out.print(", ");
			System.out.print(arr[i]);
		}
		if(switchNumber < 1){
			System.out.println(" - Unsorted array ~~~~~~~~~~~");
		}else{
			System.out.println(" - switchNumber # " + switchNumber);	
		}
	}
}