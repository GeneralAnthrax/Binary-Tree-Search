/*
 * Name: Kaleb Hamrick
 * Instructor:
 * Date:12/27/17
 * Assignment: Project 4 (Binary Search Trees)
 * Purpose:
 */
package project4;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
	
	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(E root) {
		super(root);
	}
	
	public BinarySearchTree(E root, BinarySearchTree<E> left, BinarySearchTree<E> right){
		super(root, left, right);
	}
	
	/**
     * Inserts item where it belongs in the tree.
     *
     * @param item The item to be inserted
     * @return true If the item is inserted, false if the item was already in
     * the tree.
     */
	public boolean add(E item) {
		// TODO Implement me.
		return false;
	}
	
	// TODO: Fill in the following block comment.
	/**
     * 
     *
     * @param target 
     * @return
     */
	public boolean contains(E target) {
		// TODO Implement me.
		return false;
	}
	
	// TODO: Fill in the following block comment.
	/**
     * 
     *
     * @param target 
     * @return 
     */
	public boolean remove(E target) {
		// TODO Implement me.
		return false;
	}

}
