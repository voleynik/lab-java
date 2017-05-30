package lab.poc.junit;
import junit.textui.*;
import junit.framework.*;

public class MsgTest extends TestCase{
  private Msg m1;
  private Msg m2;

  public MsgTest(String testCaseName){
		super(testCaseName);
	}

  public static void main(String[] args) {
    TestRunner.run(MsgTest.class);
  }

  protected void setUp() {
		m1 = new Msg("Hello ");
    m2 = new Msg("World!");
	}

  public void testAddWithAssertEquals(){
    Msg newMsg = new Msg("Hello World!");
		assertEquals(newMsg.getMsgText(), (m1.add(m2)).getMsgText());
  }

  public void testAddWithAssertTrue(){
    Msg newMsg = new Msg("Hello World!");
    assertTrue("Error message if needed.", newMsg.getMsgText().equals(m1.add(m2).getMsgText()));
  }
}