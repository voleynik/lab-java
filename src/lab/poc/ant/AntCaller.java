package lab.poc.ant;
/**
 * 
 */
public class AntCaller {

	public static void main(String[] args) {
		String buildFile = "K:/a1/projects-a1/lab/labUtil/java/lab/ant/AntCaller.xml";
		                 // K:\a1\projects-a1\lab\labUtil\java\lab\ant
		String[] antArgs = {"-f", buildFile};
//		org.apache.tools.ant.Main.main(antArgs);
		System.out.println("Ant done.");
	}
}
