package math;

import java.math.BigInteger;

public class Combinatorics {
	public static BigInteger combination(BigInteger poolI,
			BigInteger chooseI) {

		if(poolI.compareTo(BigInteger.ZERO)<0||chooseI.compareTo(BigInteger.ZERO)<0){
			throw new ArithmeticException("Cannot take combinations of negative numbers");
		}
		if(poolI.compareTo(chooseI)<0){
			return BigInteger.ZERO;
		}
		if(chooseI.compareTo(BigInteger.ZERO)==0){
			return BigInteger.ONE;
		}
		
		final BigRational pool = new BigRational(poolI,BigInteger.ONE);
		final BigRational choose= new BigRational(chooseI,BigInteger.ONE);
		final BigRational one = new BigRational(1);
		final BigRational two = new BigRational(2);
		BigRational i = pool.minus(choose).plus(one);
		BigRational j = choose;
		BigRational total = one;
		while (i.compareTo(pool) <= 0
				&& j.compareTo(two) >= 0) {
			total = total.times(i);
			total = total.dividedBy(j);
			i = i.plus(one);
			j = j.minus(one);
		}
		while (i.compareTo(pool) <= 0) {
			total = total.times(i);
			i = i.plus(one);
		}
		while (j.compareTo(two) >= 0) {
			total = total.dividedBy(j);
			j = j.minus(one);
		}
		return total.bigIntegerValue();

	}
}
