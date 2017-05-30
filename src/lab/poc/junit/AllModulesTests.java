package lab.poc.junit;
import junit.framework.*;
import junit.textui.*;
//import junit.tests.*;
/**
 * TestSuite that runs all the sample tests
 */
public class AllModulesTests {

    public static void main(String[] args) {
	  TestRunner.run( suite() );
    }

    public static Test suite() {
	  TestSuite suite= new TestSuite("All JUnit Tests");
//	  suite.addTest(new TestSuite(ModuleATests.class));//~DOES NOT WORK!!!
      suite.addTest(new TestSuite(MoneyTest.class));
      suite.addTest(new TestSuite(MsgTest.class));
      return suite;
    }
}