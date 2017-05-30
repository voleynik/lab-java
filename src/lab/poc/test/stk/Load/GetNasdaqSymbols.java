package lab.poc.test.stk.Load;
import java.io.File;
import java.io.FileReader;

import lab.poc.jdbc.Db;
import lab.poc.stk.ListNasdaq;
import lab.poc.stk.StkSql;
import lab.poc.util.Util;

public class GetNasdaqSymbols {

	public static void main(String[] args) throws Exception{
		
		//~ Get test file containing content recieved submitting a request with URL
		//~ http://www.nasdaq.com/asp/symbols.asp?exchange=Q&start=A&Type=1&sort=name&Type=0	
		Db.userDir = "K:/db";
		File f = new File("K:/a1/projects-a1/Nasdaq-Symbols.html");
		FileReader fr = new FileReader(f);
		char[] htmlDocChars = new char[(int)f.length()];
		fr.read(htmlDocChars);
		int rowsAdded = StkSql.add(Util.getAsObjectArray(ListNasdaq.getNasdaqSymbols(new String(htmlDocChars))));
		System.out.println("Rows added: " + rowsAdded);
	}
}