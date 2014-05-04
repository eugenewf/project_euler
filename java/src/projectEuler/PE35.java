package projectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import math.PermutationIterator;
import math.Primes;

public class PE35 {

	/*
	 * 
	 * The number, 197, is called a circular prime because
	 * all rotations of the digits: 197, 971, and 719, are
	 * themselves prime.
	 * 
	 * There are thirteen such primes below 100: 2, 3, 5, 7,
	 * 11, 13, 17, 31, 37, 71, 73, 79, and 97.
	 * 
	 * How many circular primes are there below one million?
	 */
	public static void main(String[] args) {
		Primes.isPrime(BigInteger.valueOf(999999));
		int answer =4;//2,3,5,7
		for(int digits = 2; digits <7; digits++){
			answer += answerForXDigits(digits);
		}
		System.out.println(answer);
	}
	
	private static int answerForXDigits(int digits){
		ArrayList <Integer> oddList = new ArrayList<Integer>(4);
		oddList.add(1);
		oddList.add(3);
		oddList.add(7);
		oddList.add(9);//numbers that contain 0,2,4,5,6,8 and are greater than five have a non-prime rotation
		PermutationIterator <Integer> permutation = new PermutationIterator<Integer>(oddList, digits, true);
		int count = 0;
		while(permutation.hasNext()){
			List<Integer> circle = permutation.next();
			boolean circularPrime = true;
			//cycle through all the starting points in the circle
			for (int i =0;i<circle.size();i++){
				int current =0;
				//construct the integer from the current starting point
				for(int j =0;j<circle.size();j++){
					current *= 10;
					current += circle.get((i+j)%circle.size());
				}
				if(!Primes.isPrime(BigInteger.valueOf(current))){
					circularPrime = false;
					break;
				}
			}
			if(circularPrime){
				count++;
			}
		}
		return count;
	}

}
