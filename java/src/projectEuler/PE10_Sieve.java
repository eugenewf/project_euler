package projectEuler;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * 
 * Find the sum of all the primes below two million.
 */
public class PE10_Sieve {
	public static void main(String[] args) {
		int i;
		boolean[] sieve = new boolean[2000000];
		long sum = 0;
		for (i = 2; i < 2000000; sieve[i++] = true)
			;
		for (i = 2; i * i < 2000000; i++) {
			if (sieve[i]) {
				System.out.println(i);
				sum += (long) i;
				if (sum < 0) {
					System.out.println("rolover error");
					return;
				}
				for (int j = i * i; j < 2000000; j += i) {
					sieve[j] = false;
				}
			}
		}
		for (; i < 2000000; i++) {
			if (sieve[i]) {
				System.out.println(i);
				sum += (long) i;
				if (sum < 0) {
					System.out.println("rolover error");
					return;
				}
			}
		}
		System.out.println(sum);
	}
}
