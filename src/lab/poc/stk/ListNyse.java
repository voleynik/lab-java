package lab.stk;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lab.util.Const;
import lab.util.Util;
public class ListNyse implements Const {
	private static final String c1 = "http://www.nyse.com/about/listed/lc_";
	private static final String c2 = ".html?ListedComp=All&start=1&startlist=1&item=1&next=clicked&firsttime=done&default=1";
	private static final String c3 = "[\"";
	private static final String c4 = "\",\"";
	private static int ctr = 1;
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static void main(String[] args) {
		double t1 = System.currentTimeMillis();
		lab.jdbc.Db.userDir = "K:/db";
		//~Process alphabet.
		for(int i = 0; i < Const.engLetters.length; i++){   
			String curUrl = new String(c1 + Const.engLetters[i] + c2);
			//System.out.println("CurUrl: " + curUrl);			
			//~ Process page.
			BufferedReader br = null;
			if(useProxy){
				//br = Util.connectToUrl(httpProtocol, httpProxy, proxyPort, curUrl, authString);
				br = Util.getBufferedReader(httpProtocol, httpProxy, proxyPort, curUrl, authString);
			}else{
				br = Util.connectToUrl(curUrl);
			}
			if(br == null){
				System.exit(1);
			}
			try {
				StkSql.add(Util.convertToArray(getSymbols(br)));
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		System.out.println("NY Time in min: " + (System.currentTimeMillis() - t1)/60000);
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
				while(curString.indexOf(c3) != -1){
					int stkEnd = curString.indexOf(c4, curString.indexOf(c3));
					if(stkEnd == -1){
						return stkSymbols;
					}
					//System.out.println("curString.length(): " + curString.length());
					stk = curString.substring(curString.indexOf(c3) + c3.length(), stkEnd);
					System.out.println(ctr++ + " " + stk);
					stkSymbols.add(stk);
					curString = curString.substring(stkEnd + c4.length());	
				}
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}finally{
			try{br.close();}catch(IOException ignore){}
		}
		return stkSymbols;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
}
