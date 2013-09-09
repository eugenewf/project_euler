package projectEuler;

/*
 * 
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
 * letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */
public class PE17 {
	public static void main(String[] args) {
		int total = 0;
		String[] number = new String[100];
		number[0] = "";
		number[1] = "ONE";
		number[2] = "TWO";
		number[3] = "THREE";
		number[4] = "FOUR";
		number[5] = "FIVE";
		number[6] = "SIX";
		number[7] = "SEVEN";
		number[8] = "EIGHT";
		number[9] = "NINE";
		number[10] = "TEN";
		number[11] = "ELEVEN";
		number[12] = "TWELVE";
		number[13] = "THIRTEEN";
		number[14] = "FOURTEEN";
		number[15] = "FIFTEEN";
		number[16] = "SIXTEEN";
		number[17] = "SEVENTEEN";
		number[18] = "EIGHTEEN";
		number[19] = "NINETEEN";
		number[20] = "TWENTY";
		number[30] = "THIRTY";
		number[40] = "FORTY";
		number[50] = "FIFTY";
		number[60] = "SIXTY";
		number[70] = "SEVENTY";
		number[80] = "EIGHTY";
		number[90] = "NINETY";

		for (int i = 1; i < 1000; i++) {
			int hundreds = (i % 1000) / 100;
			int tens = (i % 100) / 10;
			int ones = i % 10;
			int count = 0;
			if (hundreds > 0) {
				count = count + number[hundreds].length()
						+ "hundred".length();
				System.out.print(number[hundreds]
						+ " hundred");
			}
			if (tens > 0 || ones > 0) {
				if (hundreds > 0) {
					count = count + "and".length();
					System.out.print(" and");
				}
				if (tens == 0) {
					count = count + number[ones].length();
					System.out.print(" " + number[ones]);
				} else if (tens == 1) {
					count = count
							+ number[(tens * 10) + ones].length();
					System.out.print(" "
							+ number[(tens * 10) + ones]);
				} else {
					count = count
							+ number[tens * 10].length()
							+ number[ones].length();
					System.out.print(" "
							+ number[tens * 10] + " "
							+ number[ones]);
				}
			}
			total = total + count;
			System.out.println(": " + count +": "+total);
		}
		System.out.println("ONE thousand: "
				+ "onethousand".length());
		total = total + "onethousand".length();
		System.out.println(total);
	}
}
