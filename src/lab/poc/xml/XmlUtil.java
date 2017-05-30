package lab.xml;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class XmlUtil {
	
    public static void main(String[] parms) {
        
      try {
          String userDir = System.getProperty("user.dir"); // V:\data-vo\projects-a1\lab\labUtil
          Document myXmlDoc = XmlUtil.getDocument(userDir + "\\java\\lab\\xml\\XmlUtilTest.xml");
          Element docRootElem = myXmlDoc.getRootElement();
          List elList = docRootElem.getChildren("test1");
          for (int i = 0; i < elList.size(); i++) {
              System.out.println("Element " + (i + 1) + ": " + ((Element)elList.get(i)).getText());
          }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Document getDocument(String f) throws IOException, JDOMException {
          return  (new SAXBuilder()).build(new File(f));
    }
    
	private XmlUtil() {
	} //~Disallow instantiation
}