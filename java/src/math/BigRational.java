package math;

import java.math.BigInteger;

public class BigRational implements Comparable<BigRational> {
	private BigInteger num;
	private BigInteger denom;

	public BigRational(BigInteger num, BigInteger denom) {
		this.num = num;
		this.denom = denom;
		reduce();
	}

	public BigRational(String num, String denom) {
		this(new BigInteger(num), new BigInteger(denom));
	}

	public BigRational(Integer num, Integer denom) {
		this(num.toString(), denom.toString());
	}

	public BigRational(Long num, Long denom) {
		this(num.toString(), denom.toString());
	}

	public BigRational(Integer num, Long denom) {
		this(num.toString(), denom.toString());
	}

	public BigRational(Long num, Integer denom) {
		this(num.toString(), denom.toString());
	}

	public BigRational(Integer num) {
		this(num, 1);
	}

	public BigRational(Long num) {
		this(num, 1);
	}

	public String toString() {
		return num.toString() + " / " + denom.toString();
	}

	private void reduce() {
		if (denom.equals(BigInteger.ZERO)) {
			throw new ArithmeticException("divide by zero");
		} else if (num.equals(BigInteger.ZERO)) {
			denom = BigInteger.ONE;
		} else {
			BigInteger gcd = num.gcd(denom);
			num = num.divide(gcd);
			denom = denom.divide(gcd);
		}
		if (denom.compareTo(BigInteger.ZERO) < 0) {
			num = num.negate();
			denom = denom.negate();
		}
	}

	public BigRational negate() {
		return new BigRational(num.negate(), denom);
	}

	public int compareTo(BigRational other) {
		return num.multiply(other.denom).compareTo(
				other.num.multiply(denom));
	}

	public BigRational abs() {
		if (compareTo(new BigRational(0)) < 0) {
			return negate();
		}
		return new BigRational(num, denom);
	}

	public BigInteger round() {
		BigInteger[] divAndRem = num
				.divideAndRemainder(denom);
		if (new BigRational(divAndRem[1], denom)
				.compareTo(new BigRational(1, 2)) > 0) {
			divAndRem[0].add(BigInteger.ONE);
		}
		return divAndRem[0];
	}

	public BigRational plus(BigRational other) {
		BigRational output = new BigRational(
				num.multiply(other.denom).add(
						other.num.multiply(denom)),
				denom.multiply(other.denom));
		output.reduce();
		return output;
	}

	public BigRational minus(BigRational other) {
		return plus(other.negate());
	}

	public BigRational times(BigRational other) {
		BigRational output = new BigRational(
				num.multiply(other.num),
				denom.multiply(other.denom));
		output.reduce();
		return output;
	}

	public BigRational dividedBy(BigRational other) {
		return times(new BigRational(other.denom, other.num));
	}

	public BigRational pow(int exponent) {
		return new BigRational(num.pow(exponent),
				denom.pow(exponent));
	}

	/* contains repetitious code, break into method calls */
	public BigRational root(Integer exponent) {

		/* code to handle negatives goes here */

		BigInteger x = num.divide(new BigInteger("2"));
		BigInteger y = denom.divide(new BigInteger("2"));

		BigInteger temp = num;
		while (x.subtract(temp).abs()
				.compareTo(BigInteger.TEN) > 0
				&& x.compareTo(BigInteger.TEN) > 0) {
			System.out.println(temp + " , " + x);
			temp = x;
			x = x.subtract(x
					.pow(exponent)
					.subtract(num)
					.divide(new BigInteger(exponent
							.toString()).multiply(x
							.pow(exponent - 1))));
		}
		while (x.pow(exponent).compareTo(num) < 0) {
			x = x.add(BigInteger.ONE);
		}
		while (x.pow(exponent).compareTo(num) > 0) {
			x = x.subtract(BigInteger.ONE);
		}
		if (x.pow(exponent).compareTo(num) != 0) {
			throw new ArithmeticException(
					"no rational root of specified exponent exists for "
							+ this);
		}

		temp = denom;
		while (y.subtract(temp).abs()
				.compareTo(BigInteger.TEN) > 0
				&& y.compareTo(BigInteger.TEN) > 0) {
			temp = y;
			y = y.subtract(y
					.pow(exponent)
					.subtract(denom)
					.divide(new BigInteger(exponent
							.toString()).multiply(y
							.pow(exponent - 1))));
		}
		while (y.pow(exponent).compareTo(denom) < 0) {
			y = y.add(BigInteger.ONE);
		}
		while (y.pow(exponent).compareTo(denom) > 0) {
			y = y.subtract(BigInteger.ONE);
		}
		if (y.pow(exponent).compareTo(denom) != 0) {
			throw new ArithmeticException(
					"no rational root of specified exponent exists for "
							+ this);
		}

		return new BigRational(x, y);
	}

	public BigRational choose(BigRational other) {

		/* code to handle negatives goes here */

		BigRational i = this.minus(other).plus(
				new BigRational(1));
		BigRational j = new BigRational(2);
		BigRational total = new BigRational(1);
		while (i.compareTo(this) <= 0
				&& j.compareTo(other) <= 0) {
			total = total.times(i);
			total = total.dividedBy(j);
			i = i.plus(new BigRational(1));
			j = j.plus(new BigRational(1));
		}
		while (i.compareTo(this) <= 0) {
			total = total.times(i);
			i = i.plus(new BigRational(1));
		}
		while (j.compareTo(other) <= 0) {
			total = total.dividedBy(j);
			j = j.plus(new BigRational(1));
		}
		return total;

	}

}
