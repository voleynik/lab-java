package lab.junit;
import junit.textui.*;
import junit.framework.*;

public class MoneyTest extends TestCase{
  private Money m1;
  private Money m2;

  public MoneyTest(String name){
		super(name);
	}

  public static void main(String[] args) {
    TestRunner.run(MoneyTest.class);
  }

  protected void setUp() {
		m1 = new Money(5);
    m2 = new Money(3);
	}

  //~Methods to be tested.
  public void testAdd(){
    Money sum = new Money(8);
		assertEquals(sum.getAmount(), (m1.add(m2)).getAmount());
  }

}