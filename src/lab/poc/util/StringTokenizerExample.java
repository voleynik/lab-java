package lab.util;

import java.util.StringTokenizer;

public class StringTokenizerExample
{
	public static void main(String[] args)
	{
		String s = "a.b.c.d.e.f";
		StringTokenizer st = new StringTokenizer(s, ".");
		while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	    }
	}

}
