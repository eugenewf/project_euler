package projectEuler;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * 
 * The following iterative sequence is defined for the set
 * of positive integers:
 * 
 * n → n/2 (n is even) n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate
 * the following sequence: 13 → 40 → 20 → 10 → 5 → 16 → 8 →
 * 4 → 2 → 1
 * 
 * It can be seen that this sequence (starting at 13 and
 * finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all
 * starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the
 * longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go
 * above one million.
 */
public class PE14 {
	public static void main(String[] args) throws Exception {
		HashMap<Long, Long> length = new HashMap<Long, Long>();
		long max = 1,maxchain=1, current = 0;
		length.put(1l, 1l);
		for (long i = 2; i < 1000000; i++) {
			if(i==837799){
				System.out.print("");
				
			}
			if (!length.containsKey(i)) {
				ArrayList<Long> chain = new ArrayList<Long>();
				current = i;
				while (true) {
					if (length.containsKey(current)) {
						for (long j : chain) {
							length.put(j, length.get(j)+length.get(current));
						}
						break;
					} else {
						for (long j : chain) {
							length.put(j, length.get(j)+1);
						}
						length.put(current, 1l);
						chain.add(current);
						if (current % 2 == 0) {
							current=current/2;
						}else{
							current=current*3+1;
						}
						if (current<0){
							throw new Exception("rollover error");
							
						}
					}
				}
				if(chain.size()>0&&length.get(chain.get(0))>maxchain){
					maxchain=length.get(chain.get(0));
					max=chain.get(0);
				}
			}
		}
		System.out.println(max+" , "+maxchain);
	}
}
