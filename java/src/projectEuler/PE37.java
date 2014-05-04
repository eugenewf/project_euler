package projectEuler;

import java.util.ArrayList;


/**
 * The number 3797 has an interesting property. Being prime
 * itself, it is possible to continuously remove digits from
 * left to right, and remain prime at each stage: 3797, 797,
 * 97, and 7. Similarly we can work from right to left:
 * 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both
 * truncatable from left to right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable
 * primes.
 */
public class PE37 {

	public static void main(String[] args) {
		final int[] appendRight = { 1, 3, 7, 9 };
		ArrayList<Integer> rightTruncatable = new ArrayList<Integer>();
		rightTruncatable.add(2);
		rightTruncatable.add(3);
		rightTruncatable.add(5);
		rightTruncatable.add(7);
		int total =0;
		for(int index =0 ; index<rightTruncatable.size();index++){//this depends on the fact that the number of right truncatable primes is finite.
			for (int append : appendRight){
				int temp = rightTruncatable.get(index)*10+append;
				if (isPrime(temp)){
					rightTruncatable.add(temp);
					if(isLeftTruncatable(temp)){
						total += temp;
					}
				}
			}
		}
		System.out.println(total);
	}

	/**
	 * Simplistic primality checker
	 * 
	 * @param n int to check
	 * @return false if n is composite, true otherwise
	 */
	private static boolean isPrime(int n) {
		if (n<2){
			return false;
		}
		if (n==2){
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks for left trucatability 
	 * @param n int to check
	 * @return false if not left truncatable, true otherwise
	 */
	public static boolean isLeftTruncatable(int n){
		int logMagnitude = (int)Math.log10(n);
		int magnitude = (int)Math.pow(10, logMagnitude);
		while(magnitude>0){
			if(!isPrime(n)){
				return false;
			}
			n -= (n / magnitude) * magnitude;
			magnitude /= 10;
		}
		return true;
	}
}
