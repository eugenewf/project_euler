package projectEuler;

public class PE39 {

	/**
	 * If p is the perimeter of a right angle triangle with
	 * integral length sides, {a,b,c}, there are exactly
	 * three solutions for p = 120.
	 * 
	 * {20,48,52}, {24,45,51}, {30,40,50}
	 * 
	 * For which value of p ≤ 1000, is the number of
	 * solutions maximised?
	 */
	public static void main(String[] args) {
		/*
		 * known: (1) a^2 + b^2 = c^2 (yay Pythagoras) (2)
		 * without loss of generality a <= b <= c (order
		 * doen't matter so we'll arrange the elements
		 * conveniently) (3) a + b + c <= 1000 (given)
		 * 
		 * so: a<=333;b<=499;c<=998 (from knowns 2 and 3)
		 */
		int[] perims = new int[1001];
		for (int a = 1; a < 334; a++) {
			for (int b = a; b < 499; b++) {
				int cSqr = a*a+b*b;
				int c = (int)Math.sqrt(cSqr);
				if(c*c == cSqr){
					if(a+b+c <= 1000){
						perims[a+b+c]++;
						System.out.println(a+","+b+","+c);
					}
				}
			}
		}
		int maxValue = 0;
		int maxIndex = 0;
		for(int i = 0; i< perims.length; i++){
			if(perims[i]>maxValue){
				maxValue=perims[i];
				maxIndex=i;
			}
		}
		System.out.println(maxIndex+": "+maxValue);
	}
}
