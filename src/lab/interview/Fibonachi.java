package lab.interview;

public class Fibonachi {

	public static void main(String[] args) {

		int before = 0;
		int after = 1;
		while (after < 100) {		
			int fnum = before + after;
			System.out.print("" + fnum + ",");
			before = after;
			after = fnum;
		}	
	}
}
