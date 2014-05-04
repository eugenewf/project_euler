package dataStructures;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * thought of the structure, can't think of a use. will come
 * up with good implementation after thinking of a data
 * paradigm that would be stored in it.
 * 
 * Tree where each node's left child is the right child of
 * it's left sibling (if left sibling exists) <blockquote>
 * 
 * <pre>
 * 
 *         0
 *        / \
 *       1   2
 *      / \ / \
 *     3   4   5
 *    / \ / \ / \
 *   6   7   8   9
 * 
 * </pre>
 * 
 * </blockquote> This implementation is for mostly complete
 * trees, so it's wastes memory in other situations.
 */
public class TriangleTree<T> implements Serializable {
	ArrayList<T> tree;

	public TriangleTree() {
		tree = new ArrayList<T>();
	}

	/**
	 * adds a data object to the end of the tree (in the
	 * example tree it would place the new data as the left
	 * child of the 6)
	 * 
	 * @param data
	 *            data object to be added
	 * @return TTPointer to the added data
	 */
	TTNode add(T data) {
		return null;
	}

	class TTNode {

	}
}
