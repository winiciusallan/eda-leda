package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		if (!(array.length == 1) && array.length > 0 && leftIndex >= 0 && rightIndex <= array.length - 1) {
			if (array.length > SIZE_LIMIT) {
				if (leftIndex < rightIndex) {
					int meio = (rightIndex + leftIndex) / 2;
					sort(array, leftIndex, meio);
					sort(array, meio + 1, rightIndex);		

					merge(array, leftIndex, meio, rightIndex);	
				}
			} else {
				insertionSort(array, leftIndex, rightIndex);
			}
		}
	}

	// private void mergeSort(T[] arr, int left, int right) {
	// 	if (left < right) {
	// 		if ((right - left + 1) > SIZE_LIMIT) {
	// 			int meio = (right + left) / 2;
	// 			mergeSort(arr, left, meio);
	// 			mergeSort(arr, meio + 1, right);	
	// 			merge(arr, left, meio, right);	
	// 			MERGESORT_APPLICATIONS++;
	// 		} else {
	// 			insertionSort(arr, left, right);
	// 			INSERTIONSORT_APPLICATIONS++;
	// 		}
	// 	}
	// }

	private void merge(T[] arr, int left, int meio, int right) {
		T[] helper = (T[]) new Comparable[arr.length];
		for (int i = left; i <= right; i++) {
			helper[i] = arr[i];
		}

		int i = left;
		int j = meio + 1;
		int k = left;

		while (i <= meio && j <= right) {
			if (helper[i].compareTo(helper[j]) <= 0) {
				arr[k++] = helper[i++]; 
			} else {
				arr[k++] = helper[j++];
			}
		}

		while (i <= meio) {
			arr[k++] = helper[i++];
		}

		while (j <= right) {
			arr[k++] = helper[j++];
		}
		MERGESORT_APPLICATIONS++;
	}

	private void insertionSort(T[] arr, int left, int right) {
		for (int i = left; i <= right; i++) {
			int j = i + 1;
			while (j > left && arr[j].compareTo(arr[j-1]) < 0) {
				Util.swap(arr, j, j - 1);
				j--;
			}
		}
		INSERTIONSORT_APPLICATIONS++;
	}

	public int getMergeSortAplications() {
		return MERGESORT_APPLICATIONS;
	}

	public int getInsertionSortAplications() {
		return INSERTIONSORT_APPLICATIONS;
	}
}
