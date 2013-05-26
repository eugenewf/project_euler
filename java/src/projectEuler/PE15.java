package projectEuler;

import math.BigRational;


/*
 * 
 * Starting in the top left corner of a 2×2 grid, and only
 * being able to move to the right and down, there are
 * exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20×20 grid?
 */
public class PE15 {
	public static void main(String[] args) {

		System.out.print(new BigRational(40).choose(new BigRational(20)));

	}

}
