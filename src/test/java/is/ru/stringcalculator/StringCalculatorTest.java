package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class StringCalculatorTest
{
	@Test
	public void testEmptyString() throws IllegalArgumentException
	{
		assertEquals(0, StringCalculator.add(""));
	}

	@Test 
	public void testOneNumber() throws IllegalArgumentException
	{
		assertEquals(1, StringCalculator.add("1")); 
	}

	@Test
	public void testTwoNumbers() throws IllegalArgumentException
	{
		assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() throws IllegalArgumentException
	{
		assertEquals(6, StringCalculator.add("1,2,3"));
	}

	@Test
	public void testNewLine() throws IllegalArgumentException
	{
		assertEquals(6, StringCalculator.add("1\n2,3"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowNegativeException() throws IllegalArgumentException
	{
		 StringCalculator.add("-1");
	}

	@Test
	public void testIgnoreGreaterThanThousand() throws IllegalArgumentException
	{
		assertEquals(2, StringCalculator.add("2,1001"));
	} 

	@Test
	public void testNewDelimiter() throws IllegalArgumentException
	{
		assertEquals(3, StringCalculator.add("//;\n1;2"));
	}
}