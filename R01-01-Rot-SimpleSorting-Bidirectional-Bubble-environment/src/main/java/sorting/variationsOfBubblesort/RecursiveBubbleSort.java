package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int j = 0; j < array.length - leftIndex - 1; j++) {
			if (array[j].compareTo(array[j + 1]) > 0) {
				Util.swap(array, j, j + 1);
			}
		}
		if (leftIndex < rightIndex) { 
			sort(array, leftIndex + 1, rightIndex);
		}
		


		// for (int j = 0; j < rightIndex; j++) {
		// 	if (array[j].compareTo(array[j + 1]) > 0) {
		// 		Util.swap(array, j, j + 1);
		// 	}
		// }
		// sort(array, 0, leftIndex + 1);
	}
	
}
