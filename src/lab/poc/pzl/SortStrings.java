package lab.poc.pzl;

import lab.poc.util.Util;

public class SortStrings {

	public static void main(String[] args) {

		String[] a1 = new String[]{ "e", "c", "d", "a", "b"  };
		String tempStr = null;
		boolean flip = false;
		int res = 0;
		
		while(true){
		
			flip = false;
			
			for( int i = 0; i < ( a1.length - 1 ); i++ ){
				res = a1[i].compareTo( a1[i + 1] );
				if( res > 0 ){
					tempStr = a1[i];
					a1[i] = a1[i + 1];
					a1[i + 1] = tempStr;
					flip = true;
				}
			}
			
			if(!flip) break;
		}
		
		Util.printArray(a1);
	}
}
