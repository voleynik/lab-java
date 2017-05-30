package lab.poc.stk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import lab.poc.util.Const;
import lab.poc.util.Util;


public class GetYahoo implements Const{
	public static final String yUrl = "http://finance.yahoo.com/q?s=";
	public static final String yho1 = "Change:";

	public static Stk getStk(String s){
		URLConnection uCon = null;
		BufferedReader br = null;
		String pageLine = null;
		if(useProxy){
			uCon = Util.getUrlConnection(httpProtocol, httpProxy, proxyPort, yUrl + s, authString);
		}else{
			uCon = Util.getUrlConnection(yUrl + s);
		}
		try {
			br = new BufferedReader(new InputStreamReader(uCon.getInputStream()));	
			pageLine = br.readLine();
			while(pageLine != null){
				System.out.println("pageLine: " + pageLine);
//				if(pageLine.indexOf(yho1) != -1){
//					//return getDouble(pageLine.substring(pageLine.indexOf(yho1) + yho1.length()));
//				}
				pageLine = br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return null;
	}
	
	public static Double getDelta(String s){
		URLConnection uCon = null;
		BufferedReader br = null;
		String pageLine = null;
		if(useProxy){
			uCon = Util.getUrlConnection(httpProtocol, httpProxy, proxyPort, yUrl + s, authString);
		}else{
			uCon = Util.getUrlConnection(yUrl + s);
		}
		try {
			br = new BufferedReader(new InputStreamReader(uCon.getInputStream()));	
			pageLine = br.readLine();
			while(pageLine != null){
				if(pageLine.indexOf(yho1) != -1){
					return getDouble(pageLine.substring(pageLine.indexOf(yho1) + yho1.length()));
				}
				pageLine = br.readLine();
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
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
		if(s.indexOf("alt=\"Down\"") != -1){
			doubleString = "-" + doubleString;
		}
		return new Double(doubleString);
	}
}
