package projectEuler;

public class PE38 {

	/**
	 * 
	 Take the number 192 and multiply it by each of 1, 2,
	 * and 3:
	 * 
	 * 192 × 1 = 192 192 × 2 = 384 192 × 3 = 576
	 * 
	 * By concatenating each product we get the 1 to 9
	 * pandigital, 192384576. We will call 192384576 the
	 * concatenated product of 192 and (1,2,3)
	 * 
	 * The same can be achieved by starting with 9 and
	 * multiplying by 1, 2, 3, 4, and 5, giving the
	 * pandigital, 918273645, which is the concatenated
	 * product of 9 and (1,2,3,4,5).
	 * 
	 * What is the largest 1 to 9 pandigital 9-digit number
	 * that can be formed as the concatenated product of an
	 * integer with (1,2, ... , n) where n > 1?
	 */
	public static void main(String[] args) {
		StringBuilder pandigital = new StringBuilder();
		boolean[] inUse = new boolean[10];
		generate(pandigital,inUse);

	}
	/**
	 * recursively checks each pandigital to see if it is a concatenated product as described above
	 * @param pandigital the number as it's being built
	 * @param inUse whether or not a digit is already used (alternative to
	 * @return false if no answer has been found, true is we're done
	 */
	private static boolean generate(StringBuilder pandigital,boolean[] inUse){
		if(pandigital.length()==9){
			if(pandigital.toString().equals("918273645")){
				System.out.println("918273645");
				return true;
			}
			if (concat(pandigital)){
				System.out.println(pandigital);
				return true;
			}
			return false;
		}
		boolean done = false;
		for (int i = 9; i>0 && !done; i--){
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
	 * determines whether pandigital is the concatenation of a sequence as described in the question.
	 * @param pandigital
	 * @return
	 */
	private static boolean concat(StringBuilder pandigital){
		/*
		 * Known:
		 * 		pandigital starts with nine and is nine digits long
		 * 		
		 * Pandigital can thus be broken up the following ways:
		 * 		1,2,2,2,2 - but we don't need to check this since it was given in the question
		 * 		2,3,3(,3) - doesn't work, too few/many digits
		 * 		3,4(,4) - doesn't work, too few/many digits
		 * 		4,5 - this one works
		 * 		5,6 - everything from here on has too few/many digits
		 * 		Except 9, 0 which doesn't work because according to the question n>1
		 */
		if(2*Integer.parseInt(pandigital.substring(0, 4)) == Integer.parseInt(pandigital.substring(4))){
			return true;
		}
		return false;
	}
}
