package lab.junit;
import junit.framework.*;
import junit.textui.*;
//import junit.tests.*;
/**
 * TestSuite that runs all the sample tests
 */
public class ModuleATests {

	public static void main(String[] args) {
      TestRunner.run( suite() );
	}

	public static Test suite() {
      TestSuite suite= new TestSuite("All Module A Tests");
      suite.addTest(new TestSuite(MoneyTest.class));
      suite.addTest(new TestSuite(MsgTest.class));
      return suite;
	}

  public ModuleATests(){
  }
}