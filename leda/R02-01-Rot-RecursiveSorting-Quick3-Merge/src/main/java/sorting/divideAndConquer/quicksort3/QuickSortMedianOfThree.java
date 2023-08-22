package sorting.divideAndConquer.quicksort3;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {
	// Refatorar código.

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivot = particiona(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}

	private int particiona(T[] v, int left, int right) {
		// Choosing pivot with median of three
		int pivotIndex = medianOfThree(v, left, right);
		T pivot = v[pivotIndex];
		Util.swap(v, left, pivotIndex);

		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (v[j].compareTo(pivot) < 0) {
				Util.swap(v, ++i, j);
			}	
		}
		
		Util.swap(v, left, i);
		return i;
	}

	private int medianOfThree(T[] v, int left, int right) {
		int meio = (right + left) / 2;

		Comparable[] elems = {v[left], v[meio], v[right]};
		Arrays.sort(elems);

		if (elems[1] == v[left]) return left;
		else if (elems[1] == v[meio]) return meio;
		else return right;
	}
}
