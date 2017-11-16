package project4;

import java.util.ArrayList;

/**
 * Class for a binary tree that stores type E objects.
 *
 * @param <E>
 *            The element type
 */

public class BinaryTree<E> {

	static protected class Node<E> {
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data) {
			this.data = data;
			left = right = null;
		}
	}

	protected Node<E> root;

	/**
	 * Constructs an empty binary tree;
	 */
	public BinaryTree() {
	}

	/**
	 * Constructs a binary tree with the given data at the root.
	 * 
	 * @param data
	 *            data for the root of the new tree.
	 */
	public BinaryTree(E data) {
		this.root = new Node<E>(data);
	}

	/**
	 * Constructs a binary tree with the given data at the root and the two
	 * given subtrees.
	 * 
	 * @param data
	 *            data for the root of the new tree.
	 * @param leftTree
	 *            left binary subtree. Null indicates empty subtree.
	 * @param rightTree
	 *            right binary subtree Null indicates empty subtree.
	 */
	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		root.left = leftTree == null ? null : leftTree.root;
		root.right = rightTree == null ? null : rightTree.root;
	}

	/**
	 * Constructs a binary tree with the given node as the root.
	 * 
	 * @param root
	 *            root node of the new tree.
	 */
	protected BinaryTree(Node<E> root) {
		this.root = root;
	}

	/**
	 * Returns the data held in the root of the tree.
	 * 
	 * @return data in the root of the tree.
	 */
	public E getData() {
		return root.data;
	}

	/**
	 * A tree is a leaf if it has a root and it's left and right subtrees are
	 * empty (null). An empty tree is not considered to be a leaf.
	 * 
	 * @return true if tree is a leaf, false otherwise
	 */
	public boolean isLeaf() {
		return isLeaf(root);
	}

	protected boolean isLeaf(Node<E> root) {
		if (root == null) {
			return false;
		} else {
			return root.left == null && root.right == null;
		}
	}

	/**
	 * The height of a tree is the number of nodes in the longest path from the
	 * root node to a leaf node.
	 * 
	 * @return the height of the tree
	 */
	public int getHeight() {
		return getHeight(root);
	}

	protected int getHeight(Node<E> root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public int getSize() {
		return getSize(root);
	}

	protected int getSize(Node<E> root) {
		if (root == null) {
			return 0;
		}
		return 1 + getSize(root.left) + getSize(root.right);
	}

	/**
	 * Method to return the in-order traversal of the binary tree as a list of
	 * elements. (Left, Root, Right)
	 * 
	 * @return A in-order traversal as a string
	 */
	public ArrayList<E> inOrderTraverse() {
		return inOrderTraverse(root);
	}

	protected ArrayList<E> inOrderTraverse(Node<E> root) {
		ArrayList<E> elements = new ArrayList<E>();
		if (root == null) {
			return elements;
		}
		elements.addAll(inOrderTraverse(root.left));
		elements.add(root.data);
		elements.addAll(inOrderTraverse(root.right));
		return elements;
	}

	/**
	 * Method to return the pre-order traversal of the binary tree as a list of
	 * elements. (Root, Left, Right)
	 * 
	 * @return A pre-order traversal as a string
	 */
	public ArrayList<E> preOrderTraverse() {
		return preOrderTraverse(root);
	}

	protected ArrayList<E> preOrderTraverse(Node<E> root) {
		ArrayList<E> elements = new ArrayList<E>();
		if (root == null) {
			return elements;
		}
		elements.add(root.data);
		elements.addAll(preOrderTraverse(root.left));
		elements.addAll(preOrderTraverse(root.right));
		return elements;
	}

	/**
	 * Method to return the post-order traversal of the binary tree as a list of
	 * elements. (Left, Right, Root)
	 * 
	 * @return A post-order traversal as a string
	 */
	public ArrayList<E> postOrderTraverse() {
		return postOrderTraverse(root);
	}

	protected ArrayList<E> postOrderTraverse(Node<E> root) {
		ArrayList<E> elements = new ArrayList<E>();
		if (root == null) {
			return elements;
		}
		elements.addAll(postOrderTraverse(root.left));
		elements.addAll(postOrderTraverse(root.right));
		elements.add(root.data);
		return elements;
	}

	/**
	 * A binary tree is full if every node has either 0 or 2 children. An empty
	 * binary tree is not full.
	 * 
	 * @return true if binary tree is full, false otherwise
	 */
	public boolean isFull() {
		return isFull(root);
	}

	protected boolean isFull(Node<E> root) {
		if (root == null) {
			return false; 
		} else {
			return isLeaf(root) || isFull(root.left) && isFull(root.right);
		}
	}

	/**
	 * A complete binary tree is a binary tree whose all levels except the last
	 * level are completely filled and all the leaves in the last level are all
	 * to the left side. The empty tree is not a complete tree.
	 * 
	 * @return true if binary tree is complete, false otherwise
	 */
	public boolean isComplete() {
		int size = getSize();
		if (root == null) {
			return false;
		}
		return isComplete(root, 0, size);
	}

	protected boolean isComplete(Node<E> root, int index, int size) {
		if (root == null) {
			return true;
		}
		if (index >= size) {
			return false;
		}
		return isComplete(root.left, 2 * index + 1, size)
				&& isComplete(root.right, 2 * index + 2, size);
	}
}
