package projectEuler;

import java.math.BigInteger;

/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 =
 * 145.
 * 
 * Find the sum of all numbers which are equal to the sum of
 * the factorial of their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not
 * included.
 */
public class PE34 {

	public static void main(String[] args) {
		int[] factorials = new int[10];
		factorials[0] = 1;
		for (int i = 1; i < 10; i++) {
			factorials[i] = factorials[i - 1] * i;
		}
		BigInteger answer = BigInteger.ZERO;
		
		// 2550000 is after the crossover between 
		// 10^x and x*(9!)
		for (int i = 3; i < 2550000; i++) {
			int temp = i;
			int total = 0;
			while (temp > 0) {
				total += factorials[temp % 10];
				temp /= 10;
			}
			if (total == i){
				answer = answer.add(BigInteger.valueOf(i));
			}
		}
		System.out.println(answer);
	}
}
