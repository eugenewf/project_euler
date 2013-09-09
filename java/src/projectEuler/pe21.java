package projectEuler;

import java.math.BigInteger;

/*
 * 
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b, then a
 * and b are an amicable pair and each of a and b are called amicable numbers.
 * 
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 * 
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class pe21 {
	public static void main(String[] args) {
		int[] dValue = new int[10000];
		BigInteger total = BigInteger.ZERO;
		for (int i = 0; i < 10000; i++) {
			dValue[i] = d(i);
		}
		for (int i = 0; i < 10000; i++) {
			if (dValue[i] < 10000) {
				if (i == dValue[dValue[i]]
						&& i != dValue[i]) {
					total = total.add(BigInteger.valueOf(i));
				}
			}
		}
		System.out.println(total);
	}

	private static int d(Integer n) {
		if (n < 1) {
			return 0;
		}
		Integer divisor = 2;
		BigInteger output = BigInteger.ONE;
		while (divisor * divisor < n) {
			if (n % divisor == 0) {
				output = output.add(
						BigInteger.valueOf(divisor)).add(
						BigInteger.valueOf(n / divisor));
			}
			divisor++;
		}
		if (divisor * divisor == n) {
			output = output.add(BigInteger.valueOf(divisor));
		}
		if (output.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
			throw new ArithmeticException(
					"integer overflow");
		}
		return output.intValue();

	}
}
