package projectEuler;

/*
 * In England the currency is made up of pound, £, and
 * pence, p, and there are eight coins in general
 * circulation:
 * 
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * 
 * It is possible to make £2 in the following way:
 * 
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * 
 * How many different ways can £2 be made using any number
 * of coins?
 */
public class PE31 {

	private static final int[] coins = {200,100,50,20,10,5,2};
	private static int count = 0;

	public static void main (String[] args){
		countTheWays(200,0);
		System.out.println(count);
	}

	private static void countTheWays(int remaining, int coin){
		if(coin==7){
			count++;
			return;
		}

		if(remaining-coins[coin]>=0){
			countTheWays(remaining-coins[coin],coin);
		}

		countTheWays(remaining,coin+1);
	}
}
