package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (!(array.length == 0 || leftIndex < 0 || rightIndex >= array.length)) {
			// int indiceMenor = leftIndex;
			// for (int j = leftIndex + 1; j < rightIndex; j++) {
			// 	if (array[j].compareTo(array[indiceMenor]) < 0) {
			// 		indiceMenor = j;
			// 	}
			// }
			// Util.swap(array, leftIndex, indiceMenor);
			if (leftIndex < rightIndex) {
				int indiceMenor = selection(array, leftIndex, rightIndex, leftIndex);
				Util.swap(array, leftIndex, indiceMenor);
				sort(array, leftIndex + 1, rightIndex);
			}
		}
	}

	// É importante que o método auxiliar armazene o menor índice para que as chamadas guardem esse valor.
	public int selection(T[] array, int left, int right, int menorIndice) {
		if (left == right) { // Caso base. left (ponteiro de iteração) chegar no fim do array.
			if (array[left].compareTo(array[menorIndice]) < 0) {
				return left;
			}
			return menorIndice;
		}
		
		if (array[left + 1].compareTo(array[menorIndice]) < 0) { // Passo recursivo. Coleta do menor índice
			menorIndice = left + 1;
		}
		return selection(array, left + 1, right, menorIndice);
	}
}

