package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	public static void main(String[] args) {
		Integer[] arr = new Integer[]{4, 3, 1, 2, 5, -1};
	}

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer floor = null;
		if (array.length > 0) {
			quickSort(array, 0, array.length - 1);
			floor = search(array, x, 0, array.length - 1); 
		}
		
		return floor;
	}

	private Integer search(Integer[] arr, Integer x, int left, int right) {
		Integer output = null; // Caso floor não exista.

		if (left <= right) {
			int meio = (right + left) / 2;
			output = arr[meio];
	
			if (output == x) {
				output = arr[meio];
			} else if (output > x) {
				output = search(arr, x, left, meio - 1);
			} else {
				output = search(arr, x, meio + 1, right);

			}
		} else if (right != -1) {
			output = arr[right];
		}


		return output;
	}

	private void quickSort(Integer[] arr, int left, int right) {
		if (arr.length > 0 && left >= 0 && right <= arr.length - 1) {
			if (left < right) {
				int pivotIndex = particiona(arr, left, right);
				quickSort(arr, left, pivotIndex - 1);
				quickSort(arr, pivotIndex + 1, right);
			}
		}
	}

	private int particiona(Integer[] arr, int left, int right) {
		Integer pivot = arr[left];
		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (arr[j].compareTo(pivot) < 0) {
				Util.swap(arr, ++i, j);
			}	
		}
		Util.swap(arr, left, i);
		return i;
	}
}
