package lab.interview;

public class ThreeDigitPolindrom {

	private static boolean isPolindrom(int p0, int p1){		
		int i1 = p0 * p1;	
		String s1 = String.valueOf(i1);
		StringBuilder sb = new StringBuilder(s1);
		String s2 = sb.reverse().toString();
		if(s1.equals(s2)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int max = 0;
		for(int i = 999; i > 99; i--){
			for(int j = i; j > 99; j--){
				if(isPolindrom(i, j)){
					System.out.println("i: " + i + ", j: " + j + ", polyndrom: " + (i * j));
					int pol = i * j;
					if(pol > max){
						max = pol;
					}
				}
			}
		}
		System.out.println("Max: " + max);
	}
}

/*
1)
999 * 999
999 * 998 
......... 
999 * 101 
999 * 100 
2)
998 * 998
998 * 996
.........
998 * 100
3)
997 * 997
.......
997 * 100 
 */