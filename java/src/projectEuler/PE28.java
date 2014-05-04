package projectEuler;

import java.math.BigInteger;

public class PE28 {

	/*
	 * 
	 * Starting with the number 1 and moving to the right in
	 * a clockwise direction a 5 by 5 spiral is formed as
	 * follows:
	 * 
	 * 21 22 23 24 25 
	 * 20  7  8  9 10 
	 * 19  6  1  2 11 
	 * 18  5  4  3 12 
	 * 17 16 15 14 13
	 * 
	 * It can be verified that the sum of the numbers on the
	 * diagonals is 101.
	 * 
	 * What is the sum of the numbers on the diagonals in a
	 * 1001 by 1001 spiral formed in the same way?
	 */
	public static void main(String[] args) {
		BigInteger two = BigInteger.valueOf(2);
		BigInteger total = BigInteger.ONE;
		BigInteger current = BigInteger.ONE;
		BigInteger step = two;
		BigInteger max = BigInteger.valueOf(1001);
		while(step.compareTo(max) < 0){
			for (int i =0;i<4;i++){
				current = current.add(step);
				total = total.add(current);
			}
			step = step.add(two);
		}
		System.out.println(total);
	}
}
