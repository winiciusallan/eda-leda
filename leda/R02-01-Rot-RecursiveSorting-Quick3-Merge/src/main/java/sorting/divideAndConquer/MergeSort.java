package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int meio = (rightIndex + leftIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio + 1, rightIndex);
			merge(array, meio, leftIndex, rightIndex);
		}
	}

	private void merge(T[] array, int meio, int left, int right) {
		T[] helper = (T[]) new Comparable[array.length];
		for (int i = 0; i < helper.length; i++) {
			helper[i] = array[i];
		}

		int i = left;
		int j = meio + 1;
		int k = left;
		// Merge
		while (i <= meio && j <= right) {
			if (helper[i].compareTo(helper[j]) <= 0) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= meio) {
			array[k++] = helper[i++];
		}

		while (j <= right) {
			array[k++] = helper[j++];
		}

	}

}
