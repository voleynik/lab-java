package lab.poc.stk;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lab.poc.util.Const;
import lab.poc.util.Util;

public class ListNasdaq implements Const{
	private static final String nsdq1 = "http://www.nasdaq.com/asp/symbols.asp?exchange=Q&start=";
	private static final String nsdq2 = "&page=";
	private static final String nsdq3 = "&sort=name&Type=0";
	private static final String nsdq4 = "Widget('";//TickerWidget.constructWidget('AEHR',
	private static final String nsdq5 = "',";
	private static final String nsdq6 = "SymbolList_table";
	
	private static int ctr = 1;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static void main(String[] args) {
		double t1 = System.currentTimeMillis();
		lab.poc.jdbc.Db.userDir = "K:/db";			
		//~ Process alphabet.
		for(int i = 0; i < Const.engLetters.length; i++){   
			String s1 = new String(nsdq1 + Const.engLetters[i] + nsdq2);
			int letterPageNumber = 1;
			//~ Process page.
			while(true){
				String curUrl = s1 + (letterPageNumber++) + nsdq3;
				BufferedReader br = null;
				if(useProxy){
					//br = Util.connectToUrl(httpProtocol, httpProxy, proxyPort, curUrl, authString);
					br = Util.getBufferedReader(httpProtocol, httpProxy, proxyPort, curUrl, authString);	
				}else{
					br = Util.connectToUrl(curUrl);
				}
				//~ Check if curUrl returns a document with list.
				int i4 = Util.stringFound(nsdq4, br);
				if(i4 == -1){
					//System.out.println(curUrl + " does not contain \"" + nsdq4 + "\"");
					break;
				}
				//System.out.println(curUrl + " contains \"" + nsdq4 + "\" in position " + i4);	
				try {
					br.reset();
					StkSql.add(Util.convertToArray(getSymbols(br)));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}	
		}
      	System.out.println("NQ Time in min: " + (System.currentTimeMillis() - t1)/60000);
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static List getSymbols(BufferedReader br){
		if(br == null){
			return null;
		}
		List stkSymbols = new ArrayList();
		String curString = null;
		String stk = "*0000*";
		try {
			while(true){
				curString = br.readLine();
				if(curString == null){
					break;
				}
				int i4 = curString.indexOf(nsdq4);
				if(i4 != -1){
					stk = curString.substring(i4 + nsdq4.length(), curString.indexOf(nsdq5));
					System.out.println(ctr++ + " " + stk);
					stkSymbols.add(stk);
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}	
		return stkSymbols;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static boolean hasList(BufferedReader br){
		if(br == null){
			return false;
		}
		char[] docChars = new char[fragmentSize];
		StringBuffer sb = new StringBuffer();
		int charRead = 0;
		try {
			for(int i = 0; i < 2; i++){ //~ Get 2 sets of char.
				charRead = br.read(docChars); //System.out.println("Part 1: \n" + new String(docChars));
				if(charRead != -1){
					sb.append(docChars);
				}
			}			
			while(true){
				if(sb.indexOf(nsdq6) != -1){ //~ Found list.
					return true;
				}
				//System.out.println("Parts 1 & 2: \n" + sb.toString());
				int sbLength = sb.length();
				sb.replace(0, sbLength, sb.substring(fragmentSize));
				//System.out.println("Part 2: \n" + sb.toString());
				charRead = br.read(docChars);
				if(charRead == -1){
					return false;
				}
				sb.append(docChars);
			}
		} catch (IOException e1) {
			return false;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	//<OLD>
	private static void doNasdaq(){	
		String symbol = undefined;
		//~ Alphabet loop
		for(int i = 0; i < Const.engLetters.length; i++){   
			String s1 = new String(nsdq1 + Const.engLetters[i] + nsdq2);
			int letterPageNumber = 1;
			while(true){
				try {
					String docText = Util.getHtmlDocumentAsString("http", "10.251.10.106", 8080, s1 + (letterPageNumber++) + nsdq3, authString);
					if(docText != null && docText.indexOf(nsdq4) != -1){
						StkSql.add(Util.getAsObjectArray(getNasdaqSymbols(docText)));
					}
				} catch (Exception e) {
					break;
				}
			}	
		}
	}
	
	public static List getNasdaqSymbols(String docFragment){
		List stkSymbols = new ArrayList();
		StringBuffer sb = new StringBuffer(docFragment);
		
		while(true){
			if(docFragment.indexOf(nsdq4) == -1){
				break;
			}
			docFragment = docFragment.substring(docFragment.indexOf(nsdq4) + nsdq4.length());   
			stkSymbols.add(docFragment.substring(0, docFragment.indexOf(nsdq5)));
		}
		return stkSymbols;
	}
	//</OLD>
}
