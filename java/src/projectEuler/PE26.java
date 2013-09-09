package projectEuler;

import java.util.HashMap;

/*
 * A unit fraction contains 1 in the numerator. The decimal representation of
 * the unit fractions with denominators 2 to 10 are given:
 * 
 * 1/2 = 0.5 1/3 = 0.(3) 1/4 = 0.25 1/5 = 0.2 1/6 = 0.1(6) 1/7 = 0.(142857) 1/8
 * = 0.125 1/9 = 0.(1) 1/10 = 0.1 Where 0.1(6) means 0.166666..., and has a
 * 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * 
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle
 * in its decimal fraction part.
 */
public class PE26 {
	/**
	 * Finds the value of d < 1000 for which 1/d contains the longest recurring
	 * cycle in its decimal fraction part.
	 * 
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {
		int best =0;
		int length=0;
		for (int i=3;i<1000;i++){
			int currentLength = recurringCycleLength(i);
			if (currentLength>length){
				length=currentLength;
				best=i;
			}
		}
		System.out.println(best);
	}

	/**
	 * Turns out I took a different approach and didn't use this after all.
	 * 
	 * Determines whether the unit fraction formed by dividing one by the input
	 * terminates when written in decimal notation.
	 * 
	 * @param input
	 *            integer input representing the denominator of the unit
	 *            fraction in question.
	 * @return true if the corresponding decimal representation terminates,
	 *         false otherwise.
	 */
	public static boolean terminates(int input) {
		while (input % 2 == 0) {
			input /= 2;
		}
		while (input % 5 == 0) {
			input /= 5;
		}
		if (input == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Determines the length of the recurring cycle of the unit fraction formed by dividing one by the input
	 * when written in decimal notation.
	 * 
	 * @param input
	 *            integer input representing the denominator of the unit
	 *            fraction in question.
	 * @return Integer length of the recurring cycle, zero if the corresponding decimal representation terminates.
	 */
	public static int recurringCycleLength(int denominator){
		int numerator =1;
		int iteration =0;
		HashMap <Integer,Integer> occurred = new HashMap<Integer,Integer>();
		while (true){
			if (iteration<0){
				throw new RuntimeException("integer overflow");
			}
			if (occurred.containsKey(numerator)){
				return iteration - occurred.get(numerator);
			}
			occurred.put(numerator, iteration);
			numerator = (numerator % denominator)*10;
			iteration++;
		}
	}
}
