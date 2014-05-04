package projectEuler;

import java.math.BigInteger;

public class PE36 {

	/**
	 * The decimal number, 585 = 10010010012 (binary), is
	 * palindromic in both bases.
	 * 
	 * Find the sum of all numbers, less than one million,
	 * which are palindromic in base 10 and base 2.
	 * 
	 * (Please note that the palindromic number, in either
	 * base, may not include leading zeros.)
	 */
	public static void main(String[] args) {
		BigInteger total = BigInteger.ZERO;
		for (Integer i =1; i<1000000; i+=2){
			if (isPalindrome(Integer.toString(i,10))&&isPalindrome(Integer.toString(i, 2))){
				total = total.add(BigInteger.valueOf(i));
			}
		}
		System.out.println(total);
	}

	private static boolean isPalindrome(String input){
		for (int i =0;i<=input.length()/2;i++){
			if(input.charAt(i) != input.charAt(input.length()-1-i)){
				return false;
			}
		}
		return true;
	}
}
