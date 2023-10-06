package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		int result = -1;

		if (!this.root.isEmpty()) {
			result = height(this.root);
		}

		return result;
	}

	private int height(BSTNode<T> node) {
		int result = 0;

		if (!node.isEmpty()) {
			result = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}

		return result;
	} 

	@Override
	public BSTNode<T> search(T element) {
		return search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> result = node;

		if (!node.getData().equals(element) || node != null) {
			if (element.compareTo(node.getData()) < 0) {
				result = search(element, (BSTNode<T>) node.getLeft());
			} else {
				result = search(element, (BSTNode<T>) node.getRight());
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(element, this.root);
		}
	}

	private void insert(T element, BSTNode<T> node) {
		if (element.compareTo(node.getData()) < 0) {
			insert(element, (BSTNode<T>) node.getLeft());
		} else if (element.compareTo(node.getData()) > 0) {
			insert(element, (BSTNode<T>) node.getRight());
		} else {
			// To be implemented insert new node.
		}
	}

	private void buildNilNode(BSTNode<T> node, T element) {
		node.setData(element);
		node.setLeft(new BSTNode<>());
		node.setRight(new BSTNode<>());
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}

	// Recursion method to get the maximum node in a BST.
	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> result = node;

		if (!node.getRight().isEmpty()) {
			result = maximum((BSTNode<T>) node.getRight()); 
		}
		
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> result = node;

		if (!node.getLeft().isEmpty()) {
			result = minimum((BSTNode<T>) node.getLeft());
		}

		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		/*
		 * Ver todos os casos para remoçao
		 * Se o nó for uma folha.
		 * Se o nó tiver grau 1.
		 * Se o nó tem 2 filhos.
		 */
	}

	@Override
	public T[] preOrder() {
		T[] arr = (T[]) new Object[size()];
		preOrder(arr, this.root, 0);

		return arr;
	}

	private void preOrder(T[] arr, BSTNode<T> node, int i) {
		if (!node.isEmpty()) {
			arr[i] = node.getData();
			i++;
			preOrder(arr, (BSTNode<T>) node.getLeft(), i);
			preOrder(arr, (BSTNode<T>) node.getRight(), i);
		}
	}

	@Override
	public T[] order() {
		T[] arr = (T[]) new Object[size()];
		order(arr, this.root, 0);

		return arr;
	}

	private void order(T[] arr, BSTNode<T> node, int i) {
		if (!node.isEmpty()) {
			i++;
			preOrder(arr, (BSTNode<T>) node.getLeft(), i);
			arr[i] = node.getData();
			preOrder(arr, (BSTNode<T>) node.getRight(), i);
		}
	}

	@Override
	public T[] postOrder() {
		T[] arr = (T[]) new Object[size()];
		postOrder(arr, this.root, 0);

		return arr;
	}

	private void postOrder(T[] arr, BSTNode<T> node, int i) {
		if (!node.isEmpty()) {
			i++;
			preOrder(arr, (BSTNode<T>) node.getLeft(), i);
			preOrder(arr, (BSTNode<T>) node.getRight(), i);
			arr[i] = node.getData();
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}
}
