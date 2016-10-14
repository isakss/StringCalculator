package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class StringCalculatorTest
{
	@Test
	public void testEmptyString() throws Exception
	{
		assertEquals(0, StringCalculator.add(""));
	}

	@Test 
	public void testOneNumber() throws Exception
	{
		assertEquals(1, StringCalculator.add("1")); 
	}

	@Test
	public void testTwoNumbers() throws Exception
	{
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() throws Exception
	{
		assertEquals(6, StringCalculator.add("1,2,3"));
	}

	@Test
	public void testNewLine() throws Exception
	{
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowNegativeException() throws Exception
	{
		 StringCalculator.add("-1");
	}
}