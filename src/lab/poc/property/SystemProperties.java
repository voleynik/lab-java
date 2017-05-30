package lab.property;
import java.util.*;

/** ~~ Print all system properties. */
public class SystemProperties {
    private static boolean d = (System.getProperty("debug", "false")).equals("true") ? true : false; //java -Ddebug=true

    public static void main(String[] args) {
        System.out.println("System properties:");
        System.out.println("------------------");
        Hashtable sysProps = System.getProperties();
        Enumeration propNames = sysProps.keys();
        while (propNames.hasMoreElements()) {
            String propName = (String)propNames.nextElement();
            String propValue = (String)sysProps.get(propName);
            System.out.print("\n-> " + propName + " = ");
            System.out.println(propValue);
        }
    }
}
