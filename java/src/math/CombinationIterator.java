package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that iterates through all combinations of a given
 * size, selected from a list.
 * 
 * @author eugene
 * 
 */
public class CombinationIterator <E> {
	private ArrayList<E> buckets = null;
	private boolean allowRepetition = false;
	private int[] iterator = null;
	private boolean hasNext = false;

	/**
	 * 
	 * @param buckets
	 *            The list of objects to select from.
	 * @param select
	 *            How many objects to select.
	 * @param allowRepetition
	 *            Whether to allow the same object to be
	 *            selected more than once.
	 */
	public CombinationIterator(List<E> buckets,
			int select, boolean allowRepetition) {
		this.buckets = new ArrayList<E>(buckets);
		this.allowRepetition = allowRepetition;
		iterator = new int[select];
		for (int i = 0; i < iterator.length; i++) {
			if (!allowRepetition) {
				iterator[i] = i;
			} else {
				iterator[i] = 0;
			}
		}
		if (buckets.size() > 0
				&& select > 0
				&& (allowRepetition || select <= buckets
						.size())) {
			hasNext = true;
		}
	}

	/**
	 * 
	 * @return True if further combinations exist, false
	 *         otherwise
	 */
	public boolean hasNext() {
		return hasNext;
	}

	/**
	 * 
	 * @return The next combination from the iterator, null
	 *         if no further combinations exist.
	 */
	public List<E> next() {
		if (!hasNext) {
			return null;
		}
		ArrayList<E> output = new ArrayList<E>(
				iterator.length);
		for (int i = 0; i < iterator.length; i++) {
			output.add(buckets.get(iterator[i]));
		}
		if (allowRepetition) {
			nextWithRepeat();
		} else {
			nextNoRepeat();
		}
		return output;
	}

	private void nextWithRepeat() {
		int i = iterator.length - 1;
		for (; i >= 0 && iterator[i] == buckets.size()-1; i--)
			;
		if(i==-1){
			hasNext = false;
			return ;
		}
		iterator[i]++;
		for(i++;i<iterator.length;i++){
			iterator[i]=iterator[i-1];
		}
	}

	private void nextNoRepeat() {
		int i = iterator.length - 1;
		for (; i >= 0 && iterator[i] == buckets.size()-iterator.length+i; i--)
			;
		if(i==-1){
			hasNext = false;
			return ;
		}
		iterator[i]++;
		for(i++;i<iterator.length;i++){
			iterator[i]=iterator[i-1]+1;
		}
	}

}
