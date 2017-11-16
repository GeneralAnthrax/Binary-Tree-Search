package project4;

import static org.junit.Assert.*;

import org.junit.Test;

import project4.BinaryTree.Node;

public class BinaryTreeTest {

	@Test
	public void testBinaryTree() {
		BinaryTree<Object> tree = new BinaryTree<Object>();
		assertNull(tree.root);
	}
	
	@Test
	public void testBinaryTreeE() {
		BinaryTree<Object> tree = new BinaryTree<Object>("hi");
		assertEquals("hi", tree.root.data);
		assertNull(tree.root.right);
		assertNull(tree.root.left);
	}
	
	@Test
	public void testBinaryTreeEBinaryTreeOfEBinaryTreeOfE() {
		BinaryTree<String> leftTree = new BinaryTree<String>();
		Node<String> leftNode = new Node<String>("left node");
		leftTree.root = leftNode;
		
		BinaryTree<String> rightTree = new BinaryTree<String>();
		Node<String> rightNode = new Node<String>("right node");
		rightTree.root = rightNode;
		
		BinaryTree<String> tree1 = new BinaryTree<String>("tree1", leftTree, rightTree);
		assertEquals("tree1", tree1.root.data);
		assertEquals(leftTree.root, tree1.root.left);
		assertEquals(rightTree.root, tree1.root.right);
		
		BinaryTree<String> tree2 = new BinaryTree<String>("tree2", null, null);
		assertNull(tree2.root.right);
		assertNull(tree2.root.left);
	}

	@Test
	public void testBinaryTreeNodeOfE() {
		Node<String> node = new Node<String>("hi");
		BinaryTree<String> tree = new BinaryTree<String>(node);
		assertEquals(node, tree.root);
		assertEquals("hi", tree.root.data);
	}

	@Test
	public void testGetData() {
		Node<String> node = new Node<String>("hi");
		BinaryTree<String> tree = new BinaryTree<String>(node);
		assertEquals("hi", tree.getData());
	}

	@Test
	public void testIsLeaf() {
		BinaryTree<String> tree = new BinaryTree<String>();
		
		/*
		 * Not Leaf
		 * 		empty tree
		 */	
		assertFalse(tree.isLeaf());
		
		/*
		 * Leaf
		 *  		root
		 */
		Node<String> root = new Node<String>("root");
		tree.root = root;
		assertTrue(tree.isLeaf());
		
		/*
		 * Not Leaf
		 *  		root
		 *  		/
		 */
		Node<String> child = new Node<String>("child");
		tree.root.left = child;
		tree.root.right = null;
		assertFalse(tree.isLeaf());
		
		/*
		 * Not Leaf
		 *  		root
		 *  		   \
		 */
		tree.root.left = null;
		tree.root.right = child;
		assertFalse(tree.isLeaf());
		
		/*
		 * Not Leaf
		 *  		root
		 *  		/  \
		 */
		tree.root.left = child;
		tree.root.right = child;
		assertFalse(tree.isLeaf());
	}

	@Test
	public void testGetHeight() {
		BinaryTree<String> tree = new BinaryTree<String>();
		
		Node<String> root = new Node<String>("node");
		Node<String> node2 = new Node<String>("node");
		Node<String> node3 = new Node<String>("node");
		Node<String> node4 = new Node<String>("node");
		Node<String> node5 = new Node<String>("node");
		Node<String> node6 = new Node<String>("node");
		
		assertEquals(0, tree.getHeight());
		
		tree.root = root;
		assertEquals(1, tree.getHeight());
		
		/*
		 *  1		root
		 *  2		/
		 */
		root.left = node2;
		assertEquals(2, tree.getHeight());
		
		/*
		 * 	1		root
		 * 	2		/  \
		 */
		root.right = node3;
		assertEquals(2, tree.getHeight());
		
		/*
		 * 	1		root
		 * 	2		/  \
		 * 	3		\
		 */		    
		node2.right = node4;
		assertEquals(3, tree.getHeight());
		
		/*
		 * 	1		root
		 * 	2		/  \
		 * 	3		\  /
		 */	
		node3.left = node5;
		assertEquals(3, tree.getHeight());
		
		/*
		 * 	1		root
		 * 	2	   /    \
		 * 	3	   \    /
		 * 	4		    \
		 */	
		node5.left = node6;
		assertEquals(4, tree.getHeight());
	}

	@Test
	public void testGetSize() {
		BinaryTree<String> tree = new BinaryTree<String>();
		
		Node<String> root = new Node<String>("node");
		Node<String> node2 = new Node<String>("node");
		Node<String> node3 = new Node<String>("node");
		Node<String> node4 = new Node<String>("node");
		Node<String> node5 = new Node<String>("node");
		Node<String> node6 = new Node<String>("node");
		
		assertEquals(0, tree.getSize());
		
		tree.root = root;
		assertEquals(1, tree.getSize());
		/*
		 *  1		root
		 *  2		/
		 */
		root.left = node2;
		assertEquals(2, tree.getSize());
		
		/*
		 * 	1		root
		 * 	23		/  \
		 */
		root.right = node3;
		assertEquals(3, tree.getSize());
		
		/*
		 * 	1		root
		 * 	23		/  \
		 * 	4		\
		 */		    
		node2.right = node4;
		assertEquals(4, tree.getSize());
		
		/*
		 * 	1		root
		 * 	23		/  \
		 * 	45		\  /
		 */	
		node3.left = node5;
		assertEquals(5, tree.getSize());
		
		/*
		 * 	1		root
		 * 	23	   /    \
		 * 	45	   \    /
		 * 	6		    \
		 */	
		node5.left = node6;
		assertEquals(6, tree.getSize());
	}

	@Test
	public void testInOrderTraverse() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		tree.root = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		Integer[] expecteds = {4, 2, 5, 1, 3};
		Integer[] actuals = new Integer[5];
		actuals = tree.inOrderTraverse().toArray(actuals);
		
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testPreOrderTraverse() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		tree.root = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		Integer[] expecteds = {1, 2, 4, 5, 3};
		Integer[] actuals = new Integer[5];
		actuals = tree.preOrderTraverse().toArray(actuals);
		
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testPostOrderTraverse() {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		Node<Integer> node5 = new Node<Integer>(5);
		
		tree.root = node1;
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		
		Integer[] expecteds = {4, 5, 2, 3, 1};
		Integer[] actuals = new Integer[5];
		actuals = tree.postOrderTraverse().toArray(actuals);
		
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void testIsFull() {
		BinaryTree<String> tree = new BinaryTree<String>();
		/*
		 * Not Full
		 * 		empty tree
		 */	
		assertFalse(tree.isFull());
		
		/*
		 * Full
		 * 			root
		 */	
		Node<String> root = new Node<String>("node");
		tree.root = root;
		assertTrue(tree.isFull());
		
		/*
		 * Not Full
		 * 			root
		 * 			/  
		 */	
		Node<String> node2 = new Node<String>("node");
		root.left = node2;
		assertFalse(tree.isFull());
		
		/*
		 * Full
		 * 			root
		 * 			/  \
		 */	
		Node<String> node3 = new Node<String>("node");
		root.right = node3;
		assertTrue(tree.isFull());
		
		/*
		 * Not Full
		 * 			root
		 * 			/  \
		 *         /
		 */	       
		Node<String> node4 = new Node<String>("node");
		node2.left = node4;
		assertFalse(tree.isFull());
		
		/*
		 * Full
		 * 			root
		 * 			/  \
		 *         /\
		 */	  
		Node<String> node5 = new Node<String>("node");
		node2.right = node5;
		assertTrue(tree.isFull());
		
		/*
		 * Not Full
		 * 			root
		 * 			   \
		 *             /\
		 */
		root.left = null;
		root.right = node2;
		assertFalse(tree.isFull());
		
		/*
		 * Full
		 * 			root
		 * 			/  \
		 *             /\
		 */
		root.left = node3;
		assertTrue(tree.isFull());
	}

	@Test
	public void testIsComplete() {
		BinaryTree<String> tree = new BinaryTree<String>();
		/*
		 * Not Complete
		 * 		empty tree
		 */	
		assertFalse(tree.isComplete());
		
		/*
		 * Complete
		 * 			root (0)
		 */	
		Node<String> node0 = new Node<String>("node");
		tree.root = node0;
		assertTrue(tree.isComplete());
		
		/*
		 * Complete
		 * 			 0
		 * 			/
		 *         1
		 */	
		Node<String> node1 = new Node<String>("node");
		node0.left = node1;
		assertTrue(tree.isComplete());
		
		/*
		 * Complete
		 * 			 0
		 * 			/ \
		 * 		   1   2
		 */	
		Node<String> node2 = new Node<String>("node");
		node0.right = node2;
		assertTrue(tree.isComplete());
		
		/*
		 * Complete
		 * 			 0
		 * 			/ \
		 *         1   2
		 *        /
		 *       3 
		 */	       
		Node<String> node3 = new Node<String>("node");
		node1.left = node3;
		assertTrue(tree.isComplete());
		
		/*
		 * Complete
		 * 			 0
		 * 			/ \
		 *         1   2
		 *        / \  
		 *       3   4
		 */ 
		Node<String> node4 = new Node<String>("node");
		node1.right = node4;
		assertTrue(tree.isComplete());
		
		/*
		 * Complete
		 * 			 0
		 * 			/ \
		 *         1   2
		 *        /\  /
		 *       3  4 5
		 */ 
		Node<String> node5 = new Node<String>("node");
		node2.left = node5;
		assertTrue(tree.isComplete());
		/*
		 * Not Complete
		 * 			 0
		 * 			/ \
		 *         1   2
		 *         \  /
		 *          4 5
		 */  
		node1.left = null;
		assertFalse(tree.isComplete());
		
		
		/*
		 * Not Complete
		 * 			 0
		 * 			/ \
		 *         1   2
		 *            / \  
		 *           5   6
		 */ 
		node1.right = null;
		Node<String> node6 = new Node<String>("node");
		node2.right = node6;
		assertFalse(tree.isComplete());
	}

}
