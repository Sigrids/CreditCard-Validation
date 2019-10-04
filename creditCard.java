import java.util.Scanner;

public class creditCard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a credit card number as a long integer:");
		long credNum = in.nextLong();
		boolean bool = isValid( credNum );
		
		System.out.print( credNum + " is " + bool );
		
	}
	
	//checking to see if credit card is valid. 
	
	public static boolean isValid(long number) {

		boolean val;
	    long p = getPrefix(number, 1);
	    long p2 = getPrefix(number, 2);
	    int n = String.valueOf(number).length();

	    if ((p == 4 || p == 5 || p == 6 || p2 == 37)&& (n < 13 || n > 16))
	    	val = true;
	    else
	    	val = false;
	    
	    if (((sumDouble(number) + sumOdd(number)) % 10) == 0)
	    	val = true;
	    else
	    	val = false;
	    	
	    if (val == true)
	        return true;
	    else
	    	return false;
	}
	
	/* The sum of every other digit, doubled, starting with the first digit. */

	public static int sumDouble(long number) {
	    int sum = 0;
	    int maxDigitLenth = 16;
	    for (int i = 1; i <= maxDigitLenth; i++)
	    {
	        if (i % 2 == 0)
	        {
	            sum = sum + getDigit((int)(number % 10) * 2);
	        }
	        number /= 10;
	    }
	    return sum;
	}

	//returns number unless greater than 9, then it sums the digits on the number.

	public static int getDigit(int number) { 
	    if (number < 10) {

	        return number;
	    }
	    else {

	        return (number / 10) + (number % 10);
	    }

	    }
	
	//add all the rest if the original numbers

	public static int sumOdd(long number) {
	    int maxDigitLength = 16;
	    int sum = 0;
	    for (int i = 1; i <= maxDigitLength; i++)
	    {

	        if (i % 2 == 1)
	        {
	            sum = sum + (int)(number % 10);
	        }
	       number /= 10;
	    }
	    return sum;
	}

	//returns n number of digits

	public static long getPrefix(long num, int n) {

	    int digit = String.valueOf(num).length()-n;

	    long prefix = num/((long)(Math.pow(10, digit)));

	    return prefix;
	    }


}

