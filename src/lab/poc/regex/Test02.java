package lab.regex;
import java.io.*;
import java.util.regex.*;
public final class Test02 {

    
    public static void main(String[] argv) {
    	Pattern pattern = Pattern.compile("- gr[ae]y or gr[ae]y");
        Matcher matcher = pattern.matcher("How to spell the color - gray or grey");
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