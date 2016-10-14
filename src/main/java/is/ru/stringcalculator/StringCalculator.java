package is.ru.stringcalculator;

public class StringCalculator
{
	public static int add(String text) throws IllegalArgumentException
	{
		if(text.equals(""))
		{
			return 0;	
		}
		else if(text.contains(","))
		{
			return sum(splitText(text));
		}
		else if(text.contains("\n") && text.contains(","))
		{
			return sum(splitText(text));
		}
		else if(text.startsWith("//"))
		{
			return sum(splitText(text));
		}
		else
		{
			return 1;
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static String[] splitText(String numbers)
	{
		String delimiter = ",|\n";

		if(numbers.startsWith("//")) 
		{
			String[] segments = numbers.split("\n", 2);
			delimiter = segments[0].substring(2);
			numbers = segments[1];
		}

		return numbers.split(delimiter);
	}

	private static int sum(String[] numbers) throws IllegalArgumentException
	{
		throwNegativeException(numbers);

		return calculateNumbers(numbers);
	}

	private static void throwNegativeException(String[] numbers) throws IllegalArgumentException
	{
		for(String number : numbers)
		{
			if(toInt(number) < 0)
			{
				throw new IllegalArgumentException("Negatives not allowed: " + toInt(number));
			}
		}
	}	

	private static int calculateNumbers(String[] numbers) throws IllegalArgumentException
	{
		int total = 0;

		for(String number : numbers)
		{
			if(toInt(number) > 1000)
			{
				continue;
			}
			total += toInt(number);
		}
		return total;
	}
}