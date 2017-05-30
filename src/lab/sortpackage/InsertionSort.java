package lab.sortpackage;

public class InsertionSort {

	public static void sort(int[] arr) {
		
		print(arr, 0);
		int n = arr.length;

		for (int i = 1; i < arr.length; i++) {

			int hole = i;
			int minValue = arr[i];

			while (hole > 0 && arr[hole - 1] > minValue) {
				arr[hole] = arr[hole -1];
				hole = hole - 1;
			}

			arr[hole] = minValue;
			print(arr, i);
		}
	}

	public static void main(String[] args) {

		int[] arr = { 7, 2, 4, 1, 5, 3 };
		sort(arr);

	}
	
	public static void print(int[] arr, int insertNumber){
		
		for (int i = 0; i < arr.length; i++){
			if(i >  0 ) System.out.print(", ");	
			System.out.print(arr[i]);	
		}
		if(insertNumber < 1){
			System.out.println(" - Unsorted array ~~~~~~~~~");
		}else{
			System.out.println(" - Insert # " + insertNumber);
		}
	}
}
