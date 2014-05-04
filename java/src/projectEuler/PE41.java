package projectEuler;

public class PE41 {

	/**
	 * 
	 We shall say that an n-digit number is pandigital if
	 * it makes use of all the digits 1 to n exactly once.
	 * For example, 2143 is a 4-digit pandigital and is also
	 * prime.
	 * 
	 * What is the largest n-digit pandigital prime that
	 * exists?
	 */
	public static void main(String[] args) {
		StringBuilder pandigital = new StringBuilder();
		boolean[] inUse = null;
		for (int i =10; i>1; i--){
			inUse=new boolean[i];
		if(generate(pandigital,inUse)){
			break;
		}
		}
	}
	/**
	 * recursively checks each pandigital to see if it is a concatenated product as described above
	 * @param pandigital the number as it's being built
	 * @param inUse whether or not a digit is already used (alternative to
	 * @return false if no answer has been found, true is we're done
	 */
	private static boolean generate(StringBuilder pandigital,boolean[] inUse){
		if(pandigital.length()==inUse.length-1){
			if (isPrime(Integer.valueOf(pandigital.toString()))){
				System.out.println(pandigital);
				return true;
			}
			return false;
		}
		boolean done = false;
		for (int i = inUse.length-1; i>0 && !done; i--){
			if(!inUse[i]){
				pandigital.append((char)(i+'0'));
				inUse[i]=true;
				done = generate(pandigital,inUse);
				inUse[i]=false;
				pandigital.deleteCharAt(pandigital.length()-1);
			}
		}
		return done;
	}
	/**
	 * Simplistic primality checker
	 * 
	 * @param n int to check
	 * @return false if n is composite, true otherwise
	 */
	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		if (n % 2 == 0) {
			return false;
		}
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
