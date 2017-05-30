package lab.object;

public class MyObject {

	private int myInt;
	private String myString;
	
	public static void main(String[] args){
		
		MyObject mo1 = new MyObject();
		MyObject mo2 = new MyObject();
		
		//~ Case A.
		System.out.println("Case A - equal objects.");
		mo1.setMyInt(100);
		mo1.setMyString("Hello!");
		mo2.setMyInt(100);
		mo2.setMyString("Hello!");
		System.out.println("mo1 = mo2: " + mo1.equals(mo2));
		System.out.println("mo1.hashCode: " + mo1.hashCode());
		System.out.println("mo2.hashCode: " + mo2.hashCode());
		
		//~ Case B.
		System.out.println();
		System.out.println("Case B - non equal objects.");
		mo2.setMyInt(200);
		mo2.setMyString("Good bye!");
		System.out.println("mo1 = mo2: " + mo1.equals(mo2));
		System.out.println("mo1.hashCode: " + mo1.hashCode());
		System.out.println("mo2.hashCode: " + mo2.hashCode());	
	}
	
	public boolean equals(Object obj){
		if (obj == null) return false;	
		if (obj == this) return true;	
		if ( ! (obj instanceof lab.object.MyObject)) return false;
		
		//~ Atributes to be used for hashCOde calculation.
		if(((MyObject)obj).getMyInt() != this.getMyInt()) return false;
		if(!((MyObject)obj).getMyString().equals(this.getMyString())) return false;		
		
		return true;
	}
	
	public int hashCode(){
		StringBuffer sb = new StringBuffer(this.getClass().getName());
		sb.append(myInt).append(myString);
		return sb.toString().hashCode();
	}
	
	public int getMyInt() {
		return myInt;
	}
	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
}
