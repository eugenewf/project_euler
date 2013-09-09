package projectEuler;

import java.math.BigInteger;
import java.util.LinkedHashSet;

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

	private static LinkedHashSet <BigInteger> primeNumbers;
	private static BigInteger maxPrime;
	public static void main(String[] args) {
		int a_Times_b = 0;
		BigInteger longestSequenceLength=BigInteger.ZERO;
		initializePrimes();
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
			if(isPrime(quadraticExpressionResult)){
				count = count.add(BigInteger.ONE);
				n = n.add(BigInteger.ONE);
			}else{
				break;
			}
		}
			return count;
	}
	private static boolean isPrime(BigInteger mayBePrime){
		if(mayBePrime.compareTo(maxPrime)>0){
			extendPrimes(mayBePrime);
		}
		if(primeNumbers.contains(mayBePrime)){
			return true;
		}
		return false;
	}
	private static void extendPrimes(BigInteger maximum){
		
	}
	private static void initializePrimes(){
		primeNumbers = new LinkedHashSet<>();
		primeNumbers.add(BigInteger.valueOf(2));
		primeNumbers.add(BigInteger.valueOf(3));
		primeNumbers.add(BigInteger.valueOf(5));
		primeNumbers.add(BigInteger.valueOf(7));
		primeNumbers.add(BigInteger.valueOf(11));
		primeNumbers.add(BigInteger.valueOf(13));
		primeNumbers.add(BigInteger.valueOf(17));
		primeNumbers.add(BigInteger.valueOf(19));
		primeNumbers.add(BigInteger.valueOf(23));
		primeNumbers.add(BigInteger.valueOf(29));
		primeNumbers.add(BigInteger.valueOf(31));
		primeNumbers.add(BigInteger.valueOf(37));
		primeNumbers.add(BigInteger.valueOf(41));
		primeNumbers.add(BigInteger.valueOf(43));
		maxPrime=BigInteger.valueOf(43);		
	}
}
