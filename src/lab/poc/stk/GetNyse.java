package lab.poc.stk;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLConnection;

import lab.poc.util.Const;
import lab.poc.util.Util;

public class GetNyse implements Const{
	//public static final String nyse1 = "http://www.nyse.com/about/listed/lcddata.html?ticker=";
	//public static final String nyse2 = "<script language=\"JavaScript\" src=\"http://marketdata.nyse.com/JTic?app=QUOT";
	public static final String nyse1 = "http://marketdata.nyse.com/JTic?app=QUOT&type=NYQUOTE&rf=JS&id=";
	public static final String nyse2 = "&cred=";
	public static final String dcKeyUrl = "http://www.nyse.com/indexes/dctool.js";
	public static String dckey = getDcKey();
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Stk getStk(String s) throws Exception {
		BufferedReader br = null;
		String pageLine = null;
		Stk stk = null;
		br = getReader(s);
		pageLine = br.readLine();	
		try {
			String sym = getNyseElement(pageLine, 7);
			if(sym.equalsIgnoreCase(s)){
				stk = new Stk();
				stk.set_s(s);
			}else{
				return null;
			}
			
			String dString = getNyseElement(pageLine, 37);
			dString = dString.replace('%', ' ').trim();
			double d = Double.valueOf(dString).doubleValue();
			stk.set_s(s);
			stk.set_d(d);
			return stk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stk;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static String getNyseElement(String s, int i){
		int b = -1;
		int e = -1;
		int p = -1;
		int c = 0;
		while(c < 2 * i){
			p = s.indexOf(doubleQuote, p + 1);
			if(c == 2 * i - 2){
				b = p + 1;
			}
			if(c == 2 * i - 1){
				e = p;
			}
			c++;
		}
		return s.substring(b, e);
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static Double getDelta(String s) throws Exception {
		BufferedReader br = null;
		String pageLine = null;
		br = getReader(s);
		pageLine = br.readLine();	
		while(pageLine.indexOf(doubleQuote) != -1){
											
		}
		return new Double(999.99d);
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	private static Double getDouble(String s){
		String doubleString = "999.99";
		int dStart = s.indexOf("(");
		if(dStart != -1){
			doubleString = s.substring(dStart + 1, s.indexOf("%", dStart));
		}
		return new Double(doubleString);
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static BufferedReader getReader(String _s) throws IOException{
		URLConnection uCon = null;
		if(useProxy){
			return Util.connectToUrl(httpProtocol, httpProxy, proxyPort, nyse1 + _s + nyse2 + dckey, authString);	
		}else{
			return Util.connectToUrl(nyse1 + _s + nyse2 + dckey);
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String getDcKey(){
		BufferedReader br = Util.getBufferedReader(httpProtocol, httpProxy, proxyPort, dcKeyUrl, authString);
		String dcKey = null;
		try {
			dcKey = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		dcKey = dcKey.substring(11, dcKey.length() - 2);
		return dcKey;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static void main(String[] parms){
		Stk stk = null;
		String symbol = "NOK";
		try {
			stk = getStk(symbol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.print(stk);
	}
}

