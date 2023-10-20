package adt.bst;

import java.util.ArrayList;

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
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		int result = -1;

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

		if (!node.isEmpty() && !node.getData().equals(element)) {
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
			if (isEmpty()) {
				this.root = new BSTNode<T>();
				this.root.setData(element);

				this.root.setLeft(new BSTNode<T>());
				this.root.getLeft().setParent(this.root);
				this.root.setRight(new BSTNode<T>());
				this.root.getRight().setParent(this.root);
			} else {
				insert(element, this.root);
			}
		}	
	}

	private void insert(T element, BSTNode<T> node) {
		if (node.isEmpty()) {
			buildNilNode(node, element);			
		} else if (element.compareTo(node.getData()) < 0) {
			insert(element, (BSTNode<T>) node.getLeft());
		} else { // (element.compareTo(node.getData()) > 0)
			insert(element, (BSTNode<T>) node.getRight());
		}
	}

	private void buildNilNode(BSTNode<T> node, T element) {
		node.setData(element);
		node.setLeft(new BSTNode<T>());
		node.getLeft().setParent(node);
		node.setRight(new BSTNode<T>());
		node.getRight().setParent(node);
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if(!isEmpty()) {
			result = maximum(this.root);
		}

		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> result = node;

		if (!node.getRight().isEmpty()) {
			result = maximum((BSTNode<T>) node.getRight()); 
		}
		
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if(!isEmpty()) {
			result = minimum(this.root);
		}

		return result;
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
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (element != null && !node.isEmpty() && !node.getRight().isEmpty()) {
			result = minimum((BSTNode<T>) node.getRight());
		} else {
			result = sucessor(element, (BSTNode<T>) node.getParent());
		}

		return result;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> node) {
		BSTNode<T> result = null;

		if (node == null || node.getData().compareTo(element) > 0) {
			result = node; 
		} else {
			result = predecessor(element, (BSTNode<T>) node.getParent());
		}

		return result;
	}


	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (element != null && !node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				result = maximum((BSTNode<T>) node.getLeft());
			} else {
				result = predecessor(element, (BSTNode<T>) node.getParent());
			}
		}

		return result;
	}
	
	// Método para buscar o predecessor subindo na árvore.
	private BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> result = null;

		if (node == null || node.getData().compareTo(element) < 0) {
			result = node;
		} else {
			result = predecessor(element, (BSTNode<T>) node.getParent());
		}

		return result;
	}

	
	@Override
	public void remove(T element) {
		if (element != null) {
			BSTNode<T> node = search(element);

			if (!isEmpty()) {
				if (node.isLeaf()) { // Caso 1.: O nó a ser removido é uma folha.
					if (node == this.root) {
						this.root.setData(null);
					} else {
						if (node.getData().compareTo(node.getParent().getData()) < 0) { // O nó a ser removido está à esquerda do pai.
							node.getParent().setLeft(node.getLeft());
						} else {
							node.getParent().setRight(node.getRight());
						}
					}
				}
				else if (hasOnlyLeftChild(node)) {
					if (node == this.root) {
						this.root = (BSTNode<T>) node.getLeft();
						this.root.setParent(null);
					} else {
						node.getLeft().setParent(node.getParent());

						if (node.getData().compareTo(node.getParent().getData()) < 0) {
							node.getParent().setLeft(node.getLeft());
						} else {
							node.getParent().setRight(node.getLeft());
						}
					}
				}
				else if (hasOnlyRightChild(node)) {
					if (node == this.root) {
						this.root = (BSTNode<T>) node.getRight();
						this.root.setParent(null);
					} else {
						node.getRight().setParent(node.getParent());

						if (node.getData().compareTo(node.getParent().getData()) < 0) {
							node.getParent().setLeft(node.getRight());
						} else {
							node.getParent().setRight(node.getRight());
						}
					}
				}
				else {
					T aux = minimum((BSTNode<T>) node.getRight()).getData();
					remove(aux);
					node.setData(aux);
				}
			} 
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> arr = new ArrayList<>();

		preOrder(arr, this.root);

		return (T[]) arr.toArray(new Comparable[this.size()]);
	}

	private void preOrder(ArrayList<T> arr, BSTNode<T> node) {
		if (!node.isEmpty()) {
			arr.add(node.getData());
			preOrder(arr, (BSTNode<T>) node.getLeft());
			preOrder(arr, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> arr = new ArrayList<>();
		order(arr, this.root);

		return (T[]) arr.toArray(new Comparable[this.size()]);
	}

	private void order(ArrayList<T> arr, BSTNode<T> node) {
		if (!node.isEmpty()) {
			order(arr, (BSTNode<T>) node.getLeft());
			arr.add(node.getData());
			order(arr, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> arr = new ArrayList<>();
		postOrder(arr, this.root);

		return (T[]) arr.toArray(new Comparable[this.size()]);
	}

	private void postOrder(ArrayList<T> arr, BSTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(arr, (BSTNode<T>) node.getLeft());
			postOrder(arr, (BSTNode<T>) node.getRight());
			arr.add(node.getData());
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

	private boolean hasOnlyLeftChild(BSTNode<T> node) {
		return node.getRight().isEmpty() && !node.getLeft().isEmpty();
	}

	private boolean hasOnlyRightChild(BSTNode<T> node) {
		return node.getLeft().isEmpty() && !node.getRight().isEmpty();
	}

}
