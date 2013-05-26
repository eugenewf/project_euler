package projectEuler;

import java.util.ArrayList;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */
public class PE10_List {
	public static void main(String[] args) {
		ArrayList<Long> primes = new ArrayList<Long>();
		boolean isprime = true;
		long sum = 2l;
		primes.add(2l);
		for (long current = 3l; current < 2000000l; current += 2l) {
			for (Long i : primes) {
				if(i*i>current){
					break;
				}
				if (current % i == 0) {
					isprime = false;
					break;
				}
			}
			if (isprime) {
				primes.add(current);
				sum += current;
				System.out.println(current);
			} else {
				isprime = true;
			}
			if (sum < 0) {
				System.out.println("rollover error");
				return;
			}
		}
		System.out.println(sum);
	}

}
