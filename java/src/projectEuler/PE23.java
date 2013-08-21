package projectEuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

/*
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * 
 * A number n is called deficient if the sum of its proper divisors is less than
 * n and it is called abundant if this sum exceeds n.
 * 
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 * 
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 */
public class PE23 {
	public static void main(String[] args) {
		HashSet <Integer> abundantMap = new HashSet<Integer>();
		ArrayList <Integer> abundantList = new ArrayList<Integer>();
		for(int i = 12;i<28124;i++){
			if (isAbundant(BigInteger.valueOf(i))){
				abundantMap.add(i);
				abundantList.add(i);
			}
		}
		BigInteger total = BigInteger.ZERO;
		int stop = 21823;
		for(int i = 1; i<=stop;i++){
			boolean isSum = false;
			for (int j = 0 ; j<abundantList.size()&&abundantList.get(j)<=i/2;j++){
				if(abundantMap.contains(i-abundantList.get(j))){
					isSum=true;
					break;
				}
			}
			if(!isSum){
				total=total.add(BigInteger.valueOf(i));
			}			
		}
		System.out.println(total);
	}
	public static boolean isAbundant(BigInteger n){
		BigInteger sum = BigInteger.ONE;
		BigInteger i =BigInteger.valueOf(2);
		for(;i.multiply(i).compareTo(n)<0;i=i.add(BigInteger.ONE)){
			BigInteger[] divAndRem = n.divideAndRemainder(i);
			if(divAndRem[1].compareTo(BigInteger.ZERO)==0){
				sum = sum.add(i).add(divAndRem[0]);
			}
		}
		if(i.multiply(i).compareTo(n)==0){
			sum = sum.add(i);
		}
		System.out.print(sum +" , "+n);
		if(sum.compareTo(n)>0){
			System.out.println(" , abundant");
			return true;
		}
		System.out.println(" , not abundant");
		return false;
	}
}