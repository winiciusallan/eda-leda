package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (!(array.length == 0 || leftIndex < 0 || rightIndex >= array.length))
			for (int i = leftIndex; i < rightIndex + 1; i++) {
				int indiceMenor = i;
				for (int j = i + 1; j < rightIndex + 1; j++) {
					if (array[j].compareTo(array[indiceMenor]) < 0) {
						indiceMenor = j;
					}
				}
				Util.swap(array, i, indiceMenor);
			}
	}
}
