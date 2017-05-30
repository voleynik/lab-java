package lab.util;
import java.util.Hashtable;

public class HashtableNull {

	public static void main(String[] args) {

		Hashtable ht = new Hashtable();
		Object o = null;
		ht.get(o); // No good, gives NullPointerException
	}

}
