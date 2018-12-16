import java.util.LinkedList;

public class LinkedTree<E> {
	Node<E> root;

	private class Node<E> {
		private int key; // the key field
		private LinkedList<E> data; // list of data associated with a key
		private Node<E> left; // reference to the left child
		private Node<E> right; // reference to the right child

		private Node(int key, E element, Node<E> leftChild, Node<E> rightChild) {
			this.key = key;
			this.data = new LinkedList<E>();
			this.left = leftChild;
			this.right = rightChild;

			this.data.add(element);
		}

		private Node(int key, E element) {
			this(key, element, null, null);
		}
	}

	public LinkedTree() {
		// your implementation goes here
		System.out.println("init tree");
		root = null;
	}

	public LinkedTree(int key, E element) {
		// your implementation goes here
		root = new Node<E>(key, element);
	}

	public void insert(int key, E element) {
		// your implementation goes here
		root = insert(root, key, element);
	}

	public LinkedList<E> search(int key) {
		// your implementation goes here
		Node<E> found = searchTree(root, key);

		if (found != null) {
			return found.data;
		}

		return null;
	}

	public void preorder(int ind) {
		// your implementation goes here
		traversePreorder(root, ind);
		System.out.println();
	}

	public void postorder(int ind) {
		// your implementation goes here
		traversePostorder(root, ind);
		System.out.println();
	}

	public void inorder(int ind) {
		// your implementation goes here
		traverseInorder(root, ind);
		System.out.println();

	}

	public LinkedList<E> delete(int key) {
		// your implementation goes here
		LinkedList<E> data = null;

		Node<E> node = searchTree(root, key);

		// found
		if (node != null) {

			// extract data for returning
			data = node.data;

			// delete this node
			root = remove(root, key);

		}

		return data;
	}

	// pvt. utility methods
	private Node<E> searchTree(Node<E> node, int key) {

		if (node == null) {
			return null;
		}

		// search left
		if (node.key > key) {
			return searchTree(node.left, key);
		}

		// search right
		if (node.key < key) {
			return searchTree(node.right, key);
		}

		return node; // eql key
	}

	private void traverseInorder(Node<E> base, int idx) {

		if (base == null) {
			System.out.println("base node is null");
			return;
		}

		// traverse left
		if (base.left != null) {
			traverseInorder(base.left, idx);
		}

		// traverse root
		if (base.data != null && base.data.size() > idx) {

			System.out.print(" " + base.data.get(idx) + " ");

		}

		// traverse right
		if (base.right != null) {
			traverseInorder(base.right, idx);
		}
	}

	private void traversePreorder(Node<E> base, int idx) {

		if (base == null) {
			return;
		}

		// traverse root
		if (base.data != null && base.data.size() > idx) {
			System.out.print(" " + base.data.get(idx) + " ");
		}

		// traverse left
		if (base.left != null) {
			traversePreorder(base.left, idx);
		}

		// traverse right
		if (base.right != null) {
			traversePreorder(base.right, idx);
		}
	}

	private void traversePostorder(Node<E> base, int idx) {

		if (base == null) {
			return;
		}

		// traverse left
		if (base.left != null) {
			traversePostorder(base.left, idx);
		}

		// traverse right
		if (base.right != null) {
			traversePostorder(base.right, idx);
		}

		// traverse root
		if (base.data != null && base.data.size() > idx) {
			System.out.print(" " + base.data.get(idx) + " ");
		}
	}

	private Node<E> findLeftMostLeaf(Node<E> node) {
		if (node == null) {
			return null;
		}

		// go until leftmost node is found
		if (node.left != null) {
			return findLeftMostLeaf(node.left);
		}

		return node;
	}

	private Node<E> insert(Node<E> node, int key, E element) {

		if (node == null) {
			node = new Node<E>(key, element);
		} else if (node.key > key) {
			node.left = insert(node.left, key, element);
		} else if (node.key < key) {
			node.right = insert(node.right, key, element);
		} else { // same node
			node.data.add(element);
		}

		return node;
	}

	private Node<E> remove(Node<E> node, int key) {

		if (node == null) {
			return null;
		}

		if (node.key > key) {

			node.left = remove(node.left, key);

		} else if (node.key < key) {

			node.right = remove(node.right, key);

		} else if (node.left != null && node.right != null) {

			Node<E> leftmost = findLeftMostLeaf(node.right);

			// copy over
			node.data = leftmost.data;
			node.key = leftmost.key;

			// delete
			node.right = remove(node.right, node.key);

		} else {
			node = node.left == null ? node.right : node.left;
		}

		return node;
	}
}
