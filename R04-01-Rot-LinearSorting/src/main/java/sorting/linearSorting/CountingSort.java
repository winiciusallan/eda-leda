package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length > 0 && leftIndex >= 0 && rightIndex < array.length) {
			Integer[] sorted = countingSort(array, leftIndex, rightIndex);
	
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = sorted[i];
			}
	
		}
	}

	private Integer[] countingSort(Integer[] arr, int left, int right) {
		int k = getBigger(arr, left, right);
		Integer[] c = new Integer[++k];
		nullToZero(arr);
		nullToZero(c);

		for(int i = left; i <= right; i++) { // Contagem
			c[arr[i]]++;
		}

		for (int i = left + 1; i < c.length; i++) { // Cumulativa
			c[i] += c[i-1];
		}

		Integer[] sorted = new Integer[arr.length];
		for (int i = right; i >= left; i--) {
			sorted[c[arr[i]] - 1] = arr[i];
			c[arr[i]]--;
		}

		return sorted;
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
