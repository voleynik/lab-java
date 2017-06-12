package lab.interview;

public class PrimeOrNot {

	public static void main(String[] args) {
		System.out.println("81 is prime: " + isPrime(81));
		System.out.println("101 is prime: " + isPrime(101));
		System.out.println("13 is prime: " + isPrime(13));
		System.out.println("151 is prime: " + isPrime(151));
		System.out.println("631 is prime: " + isPrime(631));
		System.out.println("9999991 is prime: " + isPrime(9999991));
		System.out.println("9999992 is prime: " + isPrime(9999992));
	}
	
	private static boolean isPrime(int n){
		if(n > 0 && n < 4){
			return true;
		}
		if(n % 2 == 0){
			return false;
		}
		for(int i = 3; i < (n - 1); i++){
			if(n % i == 0){
				System.out.print("Divider of " + n + " is " + i + " - ");
				return false;
			}
		}
		return true;
	}
}
 