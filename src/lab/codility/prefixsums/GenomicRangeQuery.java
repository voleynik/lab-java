package lab.codility.prefixsums;


// DNA sequence - A, C, G and T have impact factors of 1, 2, 3 and 4, respectively.
public class GenomicRangeQuery {

	public int[] solution(String S, int[] P, int[] Q){
		
		java.util.Map<String, Integer> m = new java.util.HashMap<String, Integer>();
		m.put("A", 1); m.put("C", 2); m.put("G", 3); m.put("T", 4);
		int[] result = new int[P.length];
		int minImp = 4;
		
		// process all queries
		for (int i = 0; i < Q.length; i++) {
			minImp = 4;
			String range = S.substring(P[i], Q[i] + 1);
			for (int j = 0; j < range.length(); j++) {
				int imp = m.get(range.substring(j, j + 1));
				if(imp < minImp){
					minImp = imp;
				}	
			}
			result[i] = minImp;
		}
		
		return result;
	}
	
	public static void main(String[] args) {

		GenomicRangeQuery sol = new GenomicRangeQuery();
		
		int[] res = null;
		
		String S = "CAGCCTA";
		int[] P = {2,5,0};
		int[] Q = {4,5,6};
		res = sol.solution(S, P, Q);
		System.out.println("res: " + res);
		
	}
}
