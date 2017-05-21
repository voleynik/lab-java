package lab.pairs;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PairsTest {

	@Test
	public void test1() {
		int[] arrInp = {9, 3, 6, 3, 7, 6, 9};
		int[] arrExp = {7};	
		int[] arrAct = Pairs.process(arrInp);
		Assert.assertArrayEquals(arrExp, arrAct);
	}
	
	@Test
	public void test2() {
		int[] arrInp = {0};
		int[] arrExp = {0};	
		int[] arrAct = Pairs.process(arrInp);
		Assert.assertArrayEquals(arrExp, arrAct);
	}
	
	@Test
	public void test3() {
		int[] arrInp = {9, 3, 6, 3, 7, 6, 9, 7};
		int[] arrExp = new int[0];	
		int[] arrAct = Pairs.process(arrInp);
		Assert.assertArrayEquals(arrExp, arrAct);
	}
}
