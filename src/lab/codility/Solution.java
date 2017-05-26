package lab.codility;
public class Solution {

	public int solution(int n1, int n2){
		
		if(n1 < 0 || n2 < 0){
			throw new IllegalArgumentException("Negatives are not allowed.");
		}
		
		String a = String.valueOf(n1);
		String b = String.valueOf(n2);
		return b.indexOf(a);
	}
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		int result = -1;
		
		try {
			result = s.solution(0, 0);
			System.out.println("result 1 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		try {
			result = s.solution(999999999, 999999999);
			System.out.println("result 2 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	
		try {
			result = s.solution(999999999, 0);
			System.out.println("result 3 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		try {
			result = s.solution(53, 1953786);
			System.out.println("result 4 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		try {
			result = s.solution(78, 195378678);
			System.out.println("result 5 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		try {
			result = s.solution(57, 1533786);
			System.out.println("result 6 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	
		try {
			result = s.solution(1, 53378671);
			System.out.println("result 7 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
		
		try {
			result = s.solution(-1, 1533786);
			System.out.println("result 8 " + result);
		} catch (Exception e) {
			System.out.println("Error " + e.getMessage());
		}
	}
}
