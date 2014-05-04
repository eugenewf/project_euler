package projectEuler;

import java.math.BigInteger;
import java.util.LinkedHashSet;
import java.util.regex.Pattern;

/*
 * We shall say that an n-digit number is pandigital if it
 * makes use of all the digits 1 to n exactly once; for
 * example, the 5-digit number, 15234, is 1 through 5
 * pandigital.
 * 
 * The product 7254 is unusual, as the identity, 39 × 186 =
 * 7254, containing multiplicand, multiplier, and product is
 * 1 through 9 pandigital.
 * 
 * Find the sum of all products whose
 * multiplicand/multiplier/product identity can be written
 * as a 1 through 9 pandigital. HINT: Some products can be
 * obtained in more than one way so be sure to only include
 * it once in your sum.
 */
public class PE32 {

	private static final Pattern[] patterns = initPatterns();

	private static Pattern[] initPatterns() {
		String template = "[^c]*c[^c]*";
		Pattern[] output = new Pattern[10];
		output[0] = Pattern.compile("[^0]{0,9}");
		for (int i = 1; i < 10; i++) {
			Character replacement = (char) ('0' + i);
			output[i] = Pattern
					.compile(template.replaceAll("c",
							replacement.toString()));
		}
		return output;
	}

	public static void main(String[] args){
		LinkedHashSet <Integer> results = new LinkedHashSet<Integer>();
		for (Integer multiplicand = 1; multiplicand <= 9876; multiplicand++){
			Integer multiplier = 0;
			for(; true; multiplier++){
				Integer product = multiplicand*multiplier;
				String toCheck = multiplicand.toString()+multiplier.toString()+product.toString();
				if(toCheck.length()>9){
					break;
				}
				if(toCheck.length()!=9){
					continue;
				}
				if(isPandigital(toCheck)){
					results.add(product);
				}
			}
		}
		BigInteger total = BigInteger.ZERO;
		for(Integer result : results){
			total = total.add(BigInteger.valueOf(result));
		}
		System.out.println(total);
	}
	
	public static boolean isPandigital(String toCheck){
		for(int i =0;i<=toCheck.length();i++){
			if(!patterns[i].matcher(toCheck).matches()){
				return false;
			}
		}
		return true;
	}
}
