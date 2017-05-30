package lab.regex;
import java.io.*;
import java.util.regex.*;
public final class Test_afPfm {
   
    public static void main(String[] argv) {
    	Pattern pattern = Pattern.compile("_afPfm=(.+?)\"");
        Matcher matcher = pattern.matcher("action=\"/SecurePay/com/verient/securepay/web/createsecuritycontext/request-security-code.jsf?_afPfm=-4ff4d1e6\">");
        boolean found = false;
        while(matcher.find()) {
            System.out.println("I found the text \"" + matcher.group() +
                               "\" starting at index " + matcher.start() +
                               " and ending at index " + matcher.end() + ".");
            found = true;
        }
        if(!found){
            System.out.println("No match found.");
        }
    }

}