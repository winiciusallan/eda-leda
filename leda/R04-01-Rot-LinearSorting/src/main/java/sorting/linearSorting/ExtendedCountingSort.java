package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length > 0 && leftIndex >= 0 && rightIndex < array.length) {
			Integer[] sorted = coutingSort(array, leftIndex, rightIndex);
	
			System.out.println(Arrays.toString(sorted));
			for (int i = 0; i < sorted.length; i++) {
				array[i + leftIndex] = sorted[i];
			}
		}
	}

	private Integer[] coutingSort(Integer[] arr, int left, int right) {
		int k = getBigger(arr, left, right);
		int menor = getMinor(arr, left, right);
		Integer[] c = new Integer[k - menor + 1]; // Espaço para comportar os números negativos mais o zero.
		nullToZero(c);


		for (int i = left; i <= right; i++) {
			c[arr[i] - menor]++;
		}

		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		Integer[] sorted = new Integer[right - left + 1];
		for (int i = right; i >= left; i--) {
			sorted[c[arr[i] - menor] - 1] = arr[i];
			c[arr[i] - menor]--;
		}

		return sorted;

	}

	private int getMinor(Integer[] arr, int left, int right) {
		int menor = arr[left];
		for (int i = left; i <= right; i++) {
			if (arr[i] < menor) {
				menor = arr[i];
			}
		}
		return menor;
	}

	private int getBigger(Integer[] arr, int left, int right) { // Linear
		int bigger = arr[0];
		for (int i = left; i <= right; i++) {
			if (arr[i] > bigger) {
				bigger = arr[i];
			}
		}
		return bigger;
	}

	private void nullToZero(Integer[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) { arr[i] = 0; }
		}
	}

}
