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
		if(numbers.contains("\n"))
		{
			return numbers.split(",|\n");
		}
		else
		{
			return numbers.split(",");
		}
	}

	private static int sum(String[] numbers) throws IllegalArgumentException
	{
		int total = 0;

		for(String number : numbers)
		{
			if(toInt(number) < 0)
			{
				throw new IllegalArgumentException("Negatives not allowed: " + toInt(number));
			}
			if(toInt(number) > 1000)
			{
				continue;
			}
			else
			{
				total += toInt(number);
			}
		}

		return total;
	}	
}