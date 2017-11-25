package project4;

import static org.junit.Assert.*;

import org.junit.Test;

import project4.BinaryTree.Node;

public class BinarySearchTreeTest {
	
	/*
	 *              lay
     *            /     \
     *           /       \
     *          /         \
     *       house         rat
     *        /  \         /  \
     *       /    \       /    \
     *      /      \     /      \
     *    cow    jack   milked  that
	 */

	@Test
	public void addTest() {
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		Node<String> lay = new Node<String>("lay");
		Node<String> house = new Node<String>("house");
		Node<String> cow = new Node<String>("cow");
		Node<String> jack = new Node<String>("jack");
		Node<String> rat = new Node<String>("rat");
		Node<String> milked = new Node<String>("milked");
		Node<String> that = new Node<String>("that");
		
		bst.root = lay;
		lay.left = house; lay.right = rat;
		house.left = cow; house.right = jack;
		rat.left = milked; rat.right = that;
		
		assertTrue(bst.add("jill"));
		String[] expecteds1 = {"cow", "house", "jack", "jill", "lay", "milked", "rat", "that"};
		String[] actuals = new String[8];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds1, actuals);
		
		assertFalse(bst.add("jack"));
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds1, actuals);
		
		assertTrue(bst.add("nasty"));
		String[] expecteds2 = {"cow", "house", "jack", "jill", "lay", "milked", "nasty", "rat", "that"};
		actuals = new String[9];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds2, actuals);
	}
	
	/*
	 *              lay
     *            /     \
     *           /       \
     *          /         \
     *       house         rat
     *        /  \         /  \
     *       /    \       /    \
     *      /      \     /      \
     *    cow    jack   milked  that
	 */

	@Test
	public void containsTest() {
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		Node<String> lay = new Node<String>("lay");
		Node<String> house = new Node<String>("house");
		Node<String> cow = new Node<String>("cow");
		Node<String> jack = new Node<String>("jack");
		Node<String> rat = new Node<String>("rat");
		Node<String> milked = new Node<String>("milked");
		Node<String> that = new Node<String>("that");
		
		bst.root = lay;
		lay.left = house; lay.right = rat;
		house.left = cow; house.right = jack;
		rat.left = milked; rat.right = that;
		
		assertTrue(bst.contains("lay"));
		assertTrue(bst.contains("house"));
		assertTrue(bst.contains("rat"));
		assertTrue(bst.contains("cow"));
		assertTrue(bst.contains("jack"));
		assertTrue(bst.contains("milked"));
		assertTrue(bst.contains("that"));
		
		assertFalse(bst.contains("data"));
		assertFalse(bst.contains("lore"));
		assertFalse(bst.contains("ink"));
		assertFalse(bst.contains("bigboi"));
		assertFalse(bst.contains("sank"));
	}
	
	/*
	 *              lay
     *            /     \
     *           /       \
     *          /         \
     *       house         rat
     *        /  \         /  \
     *       /    \       /    \
     *      /      \     /      \
     *    cow    jack   milked  that
     *                   / \
     *                  /   \
     *                lit   nap
	 */
	
	@Test
	public void removeTest() {
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		Node<String> lay = new Node<String>("lay");
		Node<String> house = new Node<String>("house");
		Node<String> cow = new Node<String>("cow");
		Node<String> jack = new Node<String>("jack");
		Node<String> rat = new Node<String>("rat");
		Node<String> milked = new Node<String>("milked");
		Node<String> lit = new Node<String>("lit");
		Node<String> nap = new Node<String>("nap");
		Node<String> that = new Node<String>("that");
		
		bst.root = lay;
		lay.left = house; lay.right = rat;
		
		assertTrue(bst.remove("lay"));
		String[] expecteds = { "house", "rat" };
		String[] actuals = new String[2];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds, actuals);
		
		bst = new BinarySearchTree<String>();
		lay = new Node<String>("lay");
		house = new Node<String>("house");
		
		bst.root = lay;
		lay.left = house; lay.right = rat;
		house.left = cow; house.right = jack;
		rat.left = milked; rat.right = that;
		milked.left = lit; milked.right = nap;
		
		assertFalse(bst.remove("jill"));
		String[] expecteds1 = { "cow", "house", "jack", "lay", "lit", "milked",
				"nap", "rat", "that" };
		actuals = new String[9];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds1, actuals);
		
		assertFalse(bst.remove("ink"));
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds1, actuals);
		
		
		assertTrue(bst.remove("jack"));
		String[] expecteds2 = { "cow", "house", "lay", "lit", "milked", "nap",
				"rat", "that" };
		actuals = new String[8];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds2, actuals);
		
		assertTrue(bst.remove("house"));
		String[] expecteds3 = { "cow", "lay", "lit", "milked", "nap", "rat",
				"that" };
		actuals = new String[7];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds3, actuals);
		
		assertTrue(bst.remove("cow"));
		String[] expecteds4 = { "lay", "lit", "milked", "nap", "rat", "that" };
		actuals = new String[6];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds4, actuals);
		
		assertTrue(bst.remove("rat"));
		String[] expecteds5 = { "lay", "lit", "milked", "nap", "that" };
		actuals = new String[5];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds5, actuals);
		
		
		assertTrue(bst.remove("milked"));
		String[] expecteds6 = { "lay", "lit", "nap", "that" };
		actuals = new String[4];
		actuals = bst.inOrderTraverse().toArray(actuals);
		assertArrayEquals(expecteds6, actuals);
	}
	
}
