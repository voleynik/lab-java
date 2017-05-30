package lab.poc.util;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class Util{
	
	public static void printArray( Object[] a ){
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i +"]: " + a[i]);
		}
	}
	
	public static void printArray( int[] a ){
		for (int i = 0; i < a.length; i++) {
			System.out.println("a[" + i +"]: " + a[i]);
		}
	}
	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static int stringFound(String pString, BufferedReader br){
		if(br == null){
			return -1;
		}
		String curString = null;
		int totalCharRead = 0;
		try {
			while(true){
				curString = br.readLine();
				if(curString == null){
					break;
				}
				if(curString.indexOf(pString) != -1){
					return totalCharRead + curString.indexOf(pString);
				}
				totalCharRead += curString.length();
				br.mark(totalCharRead);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
		return -1;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static URLConnection getUrlConnection(String curUrl){
		//~ Setup connection and get br.
		try {
			URL url = new URL(curUrl);
			return url.openConnection();
		} catch (Exception e) {
			Lgr.log(e, 	"\n Can't connect using" + "\n URL: " + curUrl);
			return null;
		}
	}	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static URLConnection getUrlConnection(String httpProtocol, String httpProxy, int proxyPort, 
												String curUrl, String authString){
		//~ Setup connection and get br.
		try {
			URL url = new URL(httpProtocol, httpProxy, proxyPort, curUrl);
			URLConnection urlCon = url.openConnection();
			String auth = "Basic " + new sun.misc.BASE64Encoder().encode(authString.getBytes());
			urlCon.setRequestProperty("Proxy-Authorization", auth);
			return urlCon;
		} catch (Exception e) {
			Lgr.log(e, 	"\n Can't connect using" + "\n Protocol: " + httpProtocol +
						"\n Proxy: " + httpProxy + "\n Proxy port: " + proxyPort + "\n URL: " + curUrl);
			return null;
		}
	}	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static BufferedReader connectToUrl(String curUrl){
		//~ Setup connection and get br.
		try {
			URL url = new URL(curUrl);
			URLConnection urlCon = url.openConnection();
			return new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		} catch (Exception e) {
			Lgr.log(e, 	"\n Can't connect using" + "\n URL: " + curUrl);
			return null;
		}
	}	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static BufferedReader connectToUrl(String httpProtocol, String httpProxy, int proxyPort, 
												String curUrl, String authString){
		System.getProperties().put( "proxySet", "true" );
		System.getProperties().put( "proxyHost", httpProxy);
		System.getProperties().put( "proxyPort", "" + proxyPort );
		
		//~ Setup connection and get br.
		try {
			URL url = new URL(curUrl);
			URLConnection urlCon = url.openConnection();
			String auth = "Basic " + new sun.misc.BASE64Encoder().encode(authString.getBytes());
			urlCon.setRequestProperty("Proxy-Authorization", auth);
			return new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		} catch (Exception e) {
			Lgr.log(e, 	"\n Can't connect using" + "\n Protocol: " + httpProtocol +
						"\n Proxy: " + httpProxy + "\n Proxy port: " + proxyPort + "\n URL: " + curUrl);
			return null;
		}
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~ Nysa test.
	public static URLConnection getURLConnection(String httpProtocol, String httpProxy, int proxyPort, 
												String curUrl, String authString){
		System.getProperties().put( "proxySet", "true" );
		System.getProperties().put( "proxyHost", httpProxy);
		System.getProperties().put( "proxyPort", "" + proxyPort );
		
		//~ Setup connection and get br.
		try {
			URL url = new URL(curUrl);
			URLConnection urlCon = url.openConnection();
			String auth = "Basic " + new sun.misc.BASE64Encoder().encode(authString.getBytes());
			urlCon.setRequestProperty("Proxy-Authorization", auth);
			return urlCon;
		} catch (Exception e) {
			Lgr.log(e, 	"\n Can't connect using" + "\n Protocol: " + httpProtocol +
						"\n Proxy: " + httpProxy + "\n Proxy port: " + proxyPort + "\n URL: " + curUrl);
			return null;
		}
	}	
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//~ Nysa test.
	public static BufferedReader getBufferedReader(String httpProtocol, String httpProxy, int proxyPort, 
												String curUrl, String authString){
		System.getProperties().put( "proxySet", "true" );
		System.getProperties().put( "proxyHost", httpProxy);
		System.getProperties().put( "proxyPort", "" + proxyPort );
		
		//~ Setup connection and get br.
		try {
			URL url = new URL(curUrl);
			URLConnection urlCon = url.openConnection();
			String auth = "Basic " + new sun.misc.BASE64Encoder().encode(authString.getBytes());
			urlCon.setRequestProperty("Proxy-Authorization", auth);
			return new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		} catch (Exception e) {
			Lgr.log(e, 	"\n Can't connect using" + "\n Protocol: " + httpProtocol +
						"\n Proxy: " + httpProxy + "\n Proxy port: " + proxyPort + "\n URL: " + curUrl);
			return null;
		}
	}	
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static String getDocFragment(URLConnection urlCon) throws Exception {
		int docLength = urlCon.getContentLength();
		char[] docChars = new char[1024];
		BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		br.read(docChars);
		return new String(docChars);
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static String getHtmlDocumentAsString(String pProtocol, String pProxy, int pPort, String urlString, String pAuthString) throws Exception {
		
		URL url = new URL(pProtocol, pProxy, pPort, urlString);
		URLConnection urlCon = url.openConnection();
		String auth = "Basic " + new sun.misc.BASE64Encoder().encode(pAuthString.getBytes());
		urlCon.setRequestProperty("Proxy-Authorization", auth);
	
		int docLength = urlCon.getContentLength();
		char[] docChars = new char[docLength];
		BufferedReader br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		br.read(docChars);
		return new String(docChars);
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~		
	public static Object[] convertToArray(List al){
		Object[] ar = new Object[al.size()];
		for(int i = 0; i < al.size(); i++){
			ar[i] = al.get(i);
		}
		return ar;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	
	public static Object[] getAsObjectArray(List pList){
		Object[] arrayOfObjects = new Object[pList.size()];
		for(int i = 0; i < pList.size(); i++){
			arrayOfObjects[i] = pList.get(i);
		}
		return arrayOfObjects;
	}
}
