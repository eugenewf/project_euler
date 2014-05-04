package projectEuler;

import java.math.BigInteger;

import math.BigRational;

/*
 * 
 * 
 * The fraction 49/98 is a curious fraction, as an
 * inexperienced mathematician in attempting to simplify it
 * may incorrectly believe that 49/98 = 4/8, which is
 * correct, is obtained by cancelling the 9s.
 * 
 * We shall consider fractions like, 30/50 = 3/5, to be
 * trivial examples.
 * 
 * There are exactly four non-trivial examples of this type
 * of fraction, less than one in value, and containing two
 * digits in the numerator and denominator.
 * 
 * If the product of these four fractions is given in its
 * lowest common terms, find the value of the denominator.
 */
public class PE33 {
	public static void main(String[] args) {
		BigRational total = new BigRational(1);
		for (Integer num = 10; num < 100; num++) {
			for (Integer denom = 10; denom < 100; denom++) {
				if (num < denom) {
						total = total.times(luckyCancels(num, denom));
				}
			}
		}
		System.out.println(total);
	}

	private static BigRational luckyCancels(Integer num,
			Integer denom) {

		BigRational input = new BigRational(num, denom);
		String numString = num.toString();
		String denomString = denom.toString();
		for (int denomPos = 0; denomPos < 2; denomPos++) {
			int numPos = numString.indexOf(denomString
					.charAt(denomPos));
			if (numPos != -1&& denomString.charAt(denomPos)!='0') {
				if (input.compareTo(falseCancel(numString,
						denomString, numPos, denomPos)) == 0) {
					return input;
				}
			}
		}
		return new BigRational(1);
	}

	private static BigRational falseCancel(
			String numString, String denomString,
			int numPos, int denomPos) {
		String newNum =
				numString.substring(0, numPos)
				+ numString.substring(numPos + 1);
		String newDenom =
				denomString.substring(0, denomPos)
				+ denomString.substring(denomPos + 1);
		if(BigInteger.ZERO.compareTo(new BigInteger(newDenom))==0){
			return new BigRational(0);
		}
		return new BigRational(newNum,newDenom);
	}
}
