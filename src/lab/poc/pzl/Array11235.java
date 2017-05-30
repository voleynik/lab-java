package lab.pzl;

public class Array11235 {

	public static void main(String args[]){
		
		int max = 10;
		int cur = 1;
		int prv = 0;
		int nxt = 0;
		
		for ( int i = 0; i < max; i++ ) {
			nxt = cur + prv;
			prv = cur;
			cur = nxt;
			System.out.println("nxn: " + nxt );
		}
	}
}
