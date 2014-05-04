package math;

import java.math.BigInteger;
import java.util.LinkedHashSet;

public class Primes {

	private static LinkedHashSet<BigInteger> primesList = initList();
	private static BigInteger max = BigInteger.valueOf(17);
	private static final BigInteger two = BigInteger
			.valueOf(2);

	private Primes() {

	}

	private static LinkedHashSet<BigInteger> initList() {
		LinkedHashSet<BigInteger> temp = new LinkedHashSet<BigInteger>();
		temp.add(BigInteger.valueOf(2));
		temp.add(BigInteger.valueOf(3));
		temp.add(BigInteger.valueOf(5));
		temp.add(BigInteger.valueOf(7));
		temp.add(BigInteger.valueOf(11));
		temp.add(BigInteger.valueOf(13));
		temp.add(BigInteger.valueOf(17));
		return temp;
	}

	public static boolean isPrime(BigInteger n) {
		while (n.compareTo(max) > 0) {
			extendList(n);
		}
		return primesList.contains(n);
	}

	synchronized public static LinkedHashSet<BigInteger> listPrimes() {
		return (LinkedHashSet<BigInteger>) primesList
				.clone();
	}

	synchronized private static void extendList(BigInteger n) {
		if (n.compareTo(max) <= 0) {
			return;
		}
		for (BigInteger i = max.add(two); i.compareTo(n) <= 0; i = i
				.add(two)) {
			for (BigInteger prime : primesList) {
				if (prime.multiply(prime).compareTo(i) > 0) {
					primesList.add(i);
					max = i;
					break;
				}
				if (i.mod(prime).equals(BigInteger.ZERO)) {
					break;
				}
			}
		}
		if (!primesList.contains(n)) {
			for (BigInteger i = n.add(n.mod(two).add(
					BigInteger.ONE)); true; i = i.add(two)) {
				for (BigInteger prime : primesList) {
					if (prime.multiply(prime).compareTo(i) > 0) {
						primesList.add(i);
						max = i;
						return;
					}
					if (i.mod(prime)
							.equals(BigInteger.ZERO)) {
						break;
					}
				}
			}
		}
	}

	/**
	 * sieve method shelved in favor of finishing this class
	 * more quickly
	 * 
	 * @deprecated reminder not to use methods that aren't
	 *             finished (yes I know that's not what
	 *             deprecated means)
	 */
	synchronized private static void extendList(
			BigInteger n, boolean sieveMethod) {
		if (n.compareTo(max) <= 0) {
			return;
		}
		while (n.subtract(max).compareTo(
				BigInteger.valueOf(Integer.MAX_VALUE - 1)) >= 0) {
			extendList(max.add(BigInteger
					.valueOf(Integer.MAX_VALUE - 1)), true);
		}
		BigInteger sieveSize = n.subtract(max).add(
				BigInteger.ONE);
		boolean[] sieve = new boolean[sieveSize.intValue()];
		for (BigInteger prime : primesList) {

		}
	}

	private static void sift(boolean[] sieve,
			BigInteger prime, BigInteger sieveSize) {

	}

}
