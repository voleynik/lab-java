package lab.pzl;

import java.util.ArrayList;
import java.util.List;

public class InsertInSortedList {

	public static void main(String[] args) {
		List sl = new ArrayList();
		
		sl.add("b");
		sl.add("c");
		sl.add("e");
		sl.add("g");
		sl.add("i");
		
		insert("abc", sl);
		System.out.println("sl: " + sl);
	}
	
	private static void insert( String s , List sl){
		for ( int i = 0; i < sl.size(); i++) {
			if( s.compareTo( (String) sl.get(i)) <  0 || // s < current string
				s.compareTo( (String) sl.get(i)) == 0 ){ // s = current string
					sl.add( i, s );
					return;
			}
		}
		sl.add( sl.size(), s );
	}
}
