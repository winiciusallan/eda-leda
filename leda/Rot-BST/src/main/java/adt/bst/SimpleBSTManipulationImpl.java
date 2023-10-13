package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	public boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;

		if (node1.isEmpty() && node2.isEmpty()) { // Chegou até o final da verificação; Árvores iguais.
			result = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			if (node1.equals(node2)) {
				result = equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) &&
						 equals((BSTNode<T>) node2.getRight(), (BSTNode<T>) node2.getRight());
			}
		}

		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;

		if (node1.isEmpty() && node2.isEmpty()) {
			result = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			result = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) &&
					 isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}

		return result;
	}
	
	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T result = null;

		if (k <= tree.size() && k >= 1) {
			result = orderStatistic((BSTNode<T>) tree.getRoot(), k, 0);
		}

		return result;
	}

	private T orderStatistic(BSTNode<T> node, int k, int i) {
		T result = null;

		if (!node.isEmpty()) {
			result = orderStatistic((BSTNode<T>) node.getLeft(), k, i);
			i++;

			if (i == k) { // A estatística de ordem.
				result = node.getData();
			}

			if (result == null) { // Não tem como ir mais para a esquerda
				result = orderStatistic((BSTNode<T>) node.getRight(), k, i);
			}
		}

		return result;
	}

}
