package projectEuler;

import java.math.BigInteger;
import math.Primes;

/*
 * 
 * Euler discovered the remarkable quadratic formula:
 * 
 * n² + n + 41
 * 
 * It turns out that the formula will produce 40 primes for the consecutive
 * values n = 0 to 39. However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is
 * divisible by 41, and certainly when n = 41, 41² + 41 + 41 is clearly
 * divisible by 41.
 * 
 * The incredible formula n² − 79n + 1601 was discovered, which produces 80
 * primes for the consecutive values n = 0 to 79. The product of the
 * coefficients, −79 and 1601, is −126479.
 * 
 * Considering quadratics of the form:
 * 
 * n² + an + b, where |a| < 1000 and |b| < 1000
 * 
 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |−4| = 4
 * 
 * Find the product of the coefficients, a and b, for the quadratic expression
 * that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 */
public class PE27 {

	public static void main(String[] args) {
		int a_Times_b = 0;
		BigInteger longestSequenceLength=BigInteger.ZERO;
		for(int a =-999;a<=999;a++){
			for (int b =-999;b<=999;b++){
				BigInteger numberOfConsecutivePrimes = consecutiveGeneratedPrimes(a, b);
				if (numberOfConsecutivePrimes.compareTo(longestSequenceLength)>0){
					longestSequenceLength = numberOfConsecutivePrimes;
					a_Times_b = a*b;
				}
			}
		}
		System.out.println(a_Times_b);
	}
	private static BigInteger consecutiveGeneratedPrimes(int a, int b){
		BigInteger count = BigInteger.ZERO;
		BigInteger n = BigInteger.ZERO;
		while(true){
			BigInteger quadraticExpressionResult = n.pow(2).add(n.multiply(BigInteger.valueOf(a))).add(BigInteger.valueOf(b));
			if(Primes.isPrime(quadraticExpressionResult)){
				count = count.add(BigInteger.ONE);
				n = n.add(BigInteger.ONE);
			}else{
				break;
			}
		}
			return count;
	}
}
