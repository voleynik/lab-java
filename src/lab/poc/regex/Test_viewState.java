package lab.poc.regex;
import java.io.*;
import java.util.regex.*;
public final class Test_viewState {
   
    public static void main(String[] argv) {
    	Pattern pattern = Pattern.compile("name=\"javax.faces.ViewState\" value=\"(.+?)\">");
        Matcher matcher = pattern.matcher("<table><input type=\"hidden\" name=\"javax.faces.ViewState\" value=\"!-4ff4d1e4\"></table>");
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