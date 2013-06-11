package pe1;
public class PE1 {
	public static void main(String[] args) {
		boolean[] factors = new boolean[1000];
		int total = 0;
		for (int i = 0; i < 1000; i++) {
			factors[i] = false;
		}
		for (int i = 3; i < 1000; i += 3) {
			factors[i] = true;
		}
		for (int i = 5; i < 1000; i += 5) {
			factors[i] = true;
		}
		for (int i = 0; i < 1000; i++) {
			if (factors[i]) {
				total += i;
			}
		}
		System.out.println(total);
	}
}
