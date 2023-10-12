package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		if (array.length > 0) {
			for (Integer v : array) {
				this.insert(v);
			}
		}

		return floor(null, numero, this.root);
	}

	private Integer floor(Integer floor, double numero, BSTNode<Integer> node) {
		if (!node.isEmpty()) {
			if (numero < node.getData()) {
				floor = floor(floor, numero, (BSTNode<Integer>) node.getLeft());
			} else if (numero > node.getData()) {
				floor = floor(node.getData(), numero, (BSTNode<Integer>) node.getRight());
			} else {
				floor = node.getData();
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		if (array.length > 0) {
			for (Integer v : array) {
				this.insert(v);
			}
		}

		return ceil(null, numero, this.root);
	}

	private Integer ceil(Integer ceil, double numero, BSTNode<Integer> node) {
		if (!node.isEmpty()) {
			if (numero < node.getData()) {
				ceil = ceil(node.getData(), numero, (BSTNode<Integer>) node.getLeft());
			} else if (numero > node.getData()) {
				ceil = ceil(ceil, numero, (BSTNode<Integer>) node.getRight());
			} else {
				ceil = node.getData();
			}
		}

		return ceil;
	}

}
