package math;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ProperFactorsList<E> implements List<E> {
	private PFLNode head;
	private BigInteger n, size;

	public ProperFactorsList(BigInteger n) {
		this.n = n; //set n to the input value
		if (n.compareTo(BigInteger.valueOf(2)) < 0) { //if n<2 no proper factors
			head = null;
			size = BigInteger.ZERO;
			return;
		}
		head= new PFLNode(BigInteger.ONE, null); //for n > 1, 1 is a proper factor
		size = BigInteger.ONE; //size =1
		BigInteger current = BigInteger.valueOf(2); //value to check for properfactorship set to 2
		PFLNode ptr =head; //position in list is the head
		
		while (current.pow(2).compareTo(n)<=0){
			BigInteger[] divAndRem = n.divideAndRemainder(current);
			
			
			//TODO
		}
			
		// TODO

	}

	@Override
	public int size() {
		if(size.compareTo(BigInteger.valueOf(Integer.MAX_VALUE))>=0){
			return Integer.MAX_VALUE;
		}
		return size.intValue();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index,
			Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	private class PFLNode {
		private BigInteger data;
		private PFLNode next;

		private PFLNode(BigInteger data, PFLNode next) {
			this.data = data;
			this.next = next;
		}
	}

}
