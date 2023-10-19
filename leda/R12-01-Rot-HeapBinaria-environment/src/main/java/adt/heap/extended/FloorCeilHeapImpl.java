package adt.heap.extended;

import java.util.Comparator;

import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}

	@Override
	public Integer floor(Integer[] array, double numero) {
		buildHeap(array);

		return floor(numero, null);
	}

	private Integer floor(double numero, Integer floor) {
		Integer root = this.extractRootElement();

		if (root != null) {
			// O número que eu quero encontrar o floor é maior que a raiz?
			// 
			if (numero >= root && (floor == null || root >= floor)) {
				floor = floor(numero, root);
			} else {
				// Em outra chamada na pilha de execução ele vai escolher outra raiz, já que estamos sempre removendo a anterior.
				floor = floor(numero, floor);
			}
		}

		return floor;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		buildHeap(array);

		return ceil(numero, null); 
	}

	private Integer ceil(double numero, Integer ceil) {
		Integer root = this.extractRootElement();

		if (root != null) {
			if (numero <= root && (ceil == null || root <= ceil)) {
				ceil = ceil(numero, root);
			} else {
				ceil = ceil(numero, ceil);
			}
		}

		return ceil;
	}

}
