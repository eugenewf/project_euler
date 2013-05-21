package pe9;

/*
 * A Pythagorean triplet is a set of three natural numbers,
 * a < b < c, for which, a2 + b2 = c2
 * 
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a
 * + b + c = 1000. Find the product abc.
 */
public class PE9 {
	public static void main(String[] args) {
		for (int a = 0; a < 333; a++) {
			for (int b = a + 1; b < 500 - a / 2; b++) {
				int c = 1000 - a - b;
				if (a * a + b * b == c * c && b<c && a<b) {
					System.out.println(a * b * c);
					return;
				}
			}
		}
	}
}
