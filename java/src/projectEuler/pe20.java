package projectEuler;

import java.math.BigInteger;

/*
 * 
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * 
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800, and the sum of the
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */
public class pe20 {
	public static void main(String[] args) {
		BigInteger noTens = BigInteger.ONE;
		BigInteger total = BigInteger.ZERO;
		for (BigInteger i = BigInteger.ONE; i.compareTo(new BigInteger(
				"100")) <= 0; i=i.add(BigInteger.ONE)) {
			noTens = noTens.multiply(i);
			for (BigInteger[] divRem = noTens.divideAndRemainder(BigInteger.TEN); 
					divRem[1].compareTo(BigInteger.TEN) == 0; 
					divRem = noTens.divideAndRemainder(BigInteger.TEN)) {
				noTens = divRem[0];
			}
		}
		while (noTens.compareTo(BigInteger.ZERO) > 0) {
			BigInteger[] divRem = noTens.divideAndRemainder(BigInteger.TEN);
			total = total.add(divRem[1]);
			noTens = divRem[0];
		}
		System.out.println(total);
	}

}
