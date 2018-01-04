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
		Node<E> newItem = new Node<E>(item);//new node from inputed item
		
		//create a new Binary tree if root is empty and input item as root
		if(getData() == null) {
			BinaryTree<E> newTree = new BinaryTree<E>(newItem);
			return true;// return true since we can add
		}
		
		Node<E> current = root;//a reference point node
		Node<E> parent = null;//a reference point node
		
		//we add to the left first 
		while(true){
			parent = current;
			
			if(item.compareTo(current.data) < 0){				
				current = current.left;
				
				if(current == null){
					parent.left = newItem;
					return true; //added so return true
					
				}
				
				//use contains method to make sure item added isn't a duplicate
				if(contains(item) == true) {
					return false;
				}
			}
			
			//add to the right
			else
				{
				
				current = current.right;
				if(current==null){
					parent.right = newItem;
					return true;
				}
			}
		}
		
	}

	
		
		
	
	
	/**
     * This method searches through the binary tree for your item
     *
     * @param target 
     * 				target is the item you wish to find in the binary tree
     * @return returns true if your item is in the binary tree
     * 		   returns false if your time is not in the binary tree
     */
	public boolean contains(E target) {
		Node<E> current = root;//used as reference point node
		
		while(current != null) {
			if(current.data == target ) {
				return true;
			}
			
			//if greater than our target we go left down the tree
			else if(current.data.compareTo(target) > 0) {
				current = current.left;
			}
			
			//else we go right down the tree
			else {
				current = current.right;
			}
		}
		
		return false;

	}
	
	
	/**
     * This method will remove the node inputed and return true if its removed
     * and will return false if the target wasn't removed or is not in the 
     * binary tree
     *
     * @param target 
     * 			target is the node you wish to remove from the binary tree
     * @return Will return true if the node was in the binary tree and removed
     * 			Will return false if nothing was removed from the binary tree
     */
	public boolean remove(E target) {
		Node<E> parent = root;//a reference node
		Node<E> current = root;// a reference node
		
		
		//I know I could have used isLeaf() method for simplicity but i prefer this way
		// since the naming convention helps me to relate back to Linux file structure
		boolean isLeftChild = false;
		
		while(current.data!=target){
			parent = current;
			
			if(current.data.compareTo(target) > 0){
				isLeftChild = true;
				current = current.left;
			}
			
			else {
				
				isLeftChild = false;
				current = current.right;
			}
			
			if(current ==null){
				return false;
			}
		}
		
		
		
		//Case 1: the node to be removed has no children (leaf node)
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			
			if(isLeftChild == true){
				parent.left = null;
			}
			
			else {
				
				parent.right = null;
			}
		}
		
		//Case 2 : this is if the node to be removed has one child (not leaf node)
		else if (current.right==null){
			if(current==root){
				root = current.left;
			}
			
			else if (isLeftChild){
				parent.left = current.left;
			}
			
			else {
				parent.right = current.left;
			}
		}
		
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}
			
			else if(isLeftChild){
				parent.left = current.right;
			}
			
			else {
				parent.right = current.right;
			}
		}
		
		else if(current.left!=null && current.right!=null){
			
			//this is when we find the minimum element in the right sub tree
			//we also use the successor method in order to replace the removed node
			Node<E> successor = getReplacemnt(current);
			
			if(current==root){
				root = successor;
			}
			
			else if(isLeftChild){
				parent.left = successor;
			}
			
			else {
				parent.right = successor;
			}
			
			successor.left = current.left;
		}
		
		return true;		
	}
	
	/**
	 * this is a helper method for the remove method
	 * it is used to replace the node that is removed from the binary tree
	 * @param deleleNode
	 * 				deleleNode is the node to be removed from the binary tree
	 * @return
	 * 			Returns the successor that will take the place of the removed node 
	 */	
	private Node<E> getReplacemnt(Node<E> deleleNode){
		Node<E> replacement = null;
		Node<E> replaceParent = null;
		Node<E> current = deleleNode.right;
		
		
		while(current != null) {
			replaceParent = replacement;
			replacement = current;
			current = current.left;
		}
		
		if(replacement != deleleNode.right) {
			replaceParent.left = replacement.right;
			replacement.right = deleleNode.right;
		}
		
		return replacement;
	}
	

}
