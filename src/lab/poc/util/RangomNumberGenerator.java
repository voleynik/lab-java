package lab.poc.util;

import java.util.Random;

public class RangomNumberGenerator {

	private static Random rnd = new Random();
	
	public static void main(String[] args) {
		
		int start = 0, end = 19;
		int[] intAr = new int[20];
		int rndInt = -1;
		for (int i = 0; i < 100000000; i++) {
			rndInt = getRandomInteger(start, end);
			intAr[rndInt - start] += 1;
		}
		
		for (int i = 0; i < intAr.length; i++) {
			System.out.println(" " + (i + start) + " - " + intAr[i] + " times.");
		}
		
	}
	
	private static int getRandomInteger(int start, int end){
		if(end <= start){
			throw new IllegalArgumentException("end must be greater than start.");
		}
		return rnd.nextInt(end - start + 1) + start;
	}
}