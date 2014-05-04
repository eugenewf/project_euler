package projectEuler;

import java.math.BigInteger;

/*
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 +
 * 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */
public class PE16 {
	public static void main(String[] args) {
		BigInteger x = new BigInteger("2").pow(1000);
		BigInteger total = BigInteger.ZERO;
		while (x.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] divAndRem = x
					.divideAndRemainder(BigInteger.TEN);
			total = total.add(divAndRem[1]);
			x = divAndRem[0];
		}

		System.out.println(total);

	}
}
