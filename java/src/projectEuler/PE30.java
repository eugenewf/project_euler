package projectEuler;

import java.util.LinkedHashSet;

/*
 * 
 * 
 * Surprisingly there are only three numbers that can be
 * written as the sum of fourth powers of their digits:
 * 
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4 
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4 
 * 9474 = 9^4 + 4^4 + 764 + 4^4
 * 
 * As 1 = 1^4 is not a sum it is not included.
 * 
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * 
 * Find the sum of all the numbers that can be written as
 * the sum of fifth powers of their digits.
 */
public class PE30 {

	private static final int[] fifths = initFifths();

	private static int[] initFifths() {
		int[] output = new int[10];
		for (int i = 0; i < 10; i++) {
			output[i] = (int) Math.pow(i, 5);
		}
		return output;
	}

	public static void main ( String[] args){
		LinkedHashSet<Integer> results = new LinkedHashSet<Integer>(); 
		int total = 0;
		//355000 is after the crossover point of X*9^5 and 10^X so there's no way a result could ever occur afterwards.
		for (int i = 2; i<355000; i++){
			if(sumOfFifths(i)==i){
				results.add(i);
				total += i;
			}
		}
		System.out.println(total);
		System.out.println(results);
	}

	private static int sumOfFifths(int input) {
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += fifths[input % 10];
			input /= 10;
		}
		return sum;
	}
}
