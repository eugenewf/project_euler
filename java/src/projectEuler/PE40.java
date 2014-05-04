package projectEuler;

import java.util.ArrayList;

public class PE40 {

	/**
	 * 
	 An irrational decimal fraction is created by
	 * concatenating the positive integers:
	 * 
	 * 0.123456789101112131415161718192021...
	 * 
	 * It can be seen that the 12th digit of the fractional
	 * part is 1.
	 * 
	 * If dn represents the nth digit of the fractional
	 * part, find the value of the following expression.
	 * 
	 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
	 */
	public static void main(String[] args) {
		ArrayList <Character> v = new ArrayList<Character>(1001001);
		v.add('0');		
		for(Integer i = 1; v.size()<1000001; i++){
			char[] cs = i.toString().toCharArray();
			for (char c : cs){
				v.add(c);
			}
		}
		int total =1;
		for(int i =1 ;i <=1000000;i*=10){
			total *= (v.get(i)-'0');
			System.out.println("* "+v.get(i)+" = "+total);
		}
	}
}
