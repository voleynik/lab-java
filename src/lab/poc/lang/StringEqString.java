package lab.lang;

public class StringEqString {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "abc";
		
		// A
		System.out.println("A~s1.hashCode: " + s1.hashCode());
		System.out.println("A~s2.hashCode: " + s2.hashCode());
		
		if(s1 == s2){
			System.out.println("A~ s1 == s2: true");
		}
		
		// B
		s2 = new String("abc");
		System.out.println("B~s2.hashCode: " + s2.hashCode());
		
		if(s1 == s2){
			System.out.println("B~ s1 == s2: true");
		}else{
			System.out.println("B~ s1 == s2: false");
		}
		
		// C
		s2 = "xyz";
		System.out.println("C~s2.hashCode: " + s2.hashCode());
		
		if(s1 == s2){
			System.out.println("C~ s1 == s2: true");
		}else{
			System.out.println("C~ s1 == s2: false");
		}
	}
}
