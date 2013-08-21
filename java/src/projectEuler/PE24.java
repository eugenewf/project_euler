package test;

import java.util.ArrayList;

/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 */

public class PE24 {

	public static void main(String[] args) {
		RPCData data = new RPCData();
		recPermCount(data);
	}

	public static RPCData recPermCount(RPCData data) {
		/*end case: data==null*/
		if (data==null){
			return null;
		}
		/*leaf case: if all ten numbers used*/
		if (data.current.size() == 10) {
			data.counter++;
			if (data.counter == 1000000) {
				for(Integer i : data.current){
					System.out.print(i);
				}
				System.out.println();
				return null;
			}
			return data;
		}
		/*recursive case: try each unused number in succession*/
		for (int i =0; i < 10;i++){
			if (!data.used[i]){
				data.current.add(i);
				data.used[i]=true;
				data = recPermCount(data);
				if (data==null){
					return null;
				}
				data.current.remove(data.current.size()-1);
				data.used[i]=false;				
			}
		}
		return data;
	}

	public static class RPCData {
		boolean[] used;
		int counter;
		ArrayList<Integer> current;
		
		RPCData(){
			used = new boolean[10];
			counter =0;
			current=new ArrayList<Integer>(10);
		}
	}
}
