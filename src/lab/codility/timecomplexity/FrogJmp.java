package lab.codility.timecomplexity;

class FrogJmp {

	public int solution(int X, int Y, int D){
		
		int dist = Y - X;
		
		int minJumps = (dist / D);
		
		int rem = dist % D;
		
		if(rem != 0){
			minJumps = minJumps + 1;
		}

		return minJumps;
	}
	
	public static void main(String[] args) {
		
		FrogJmp sol = new FrogJmp();
		
		int minJumps = sol.solution(0, 10, 3);
		System.out.println("minJumps: " + minJumps);

	}
	
//	public int solution(int x, int y, int d){
//
//		int position = x;
//		int jumpCounter = 0;
//		
//		while (position < y) {
//			jumpCounter++;
//			position = position + d;
//		}
//
//		return jumpCounter;
//	}
}