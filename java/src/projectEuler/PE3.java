package projectEuler;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number
 * 600851475143 ?
 */
public class PE3 {
	public static void main(String[] args) {
		long remaining = 600851475143l, current = 3l;
		while (remaining > 1) {
			while (remaining % current == 0) {
				remaining /= current;
			}
			current += 2;
		}
		System.out.println(current - 2);
	}
}
