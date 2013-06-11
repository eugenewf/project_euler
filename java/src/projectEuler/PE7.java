package projectEuler;

import java.util.ArrayList;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11,
 * and 13, we can see that the 6th prime is 13.
 * 
 * What is the 10 001st prime number?
 */
public class PE7 {
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>(
				10001);
		boolean isprime = true;
		primes.add(2);
		for (int current = 3; primes.size() < 10001; current++) {
			for (Integer i : primes) {
				if (current % i == 0) {
					isprime = false;
					break;
				}
			}
			if (isprime) {
				primes.add(current);
			} else {
				isprime = true;
			}
		}
		System.out.println(primes.get(10000));
	}
}
