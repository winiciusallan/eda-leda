package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		if (array.length < k) { k = 0; }

		T[] kthLargests = (T[]) new Comparable[k];

		if (array.length >= k) {
			for (int i = 0; i < kthLargests.length; i++) {
				kthLargests[i] = orderStatistics(array, array.length - k + 1);
				k--;
			}
		}

		return kthLargests;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		return orderStatistics(array, k, 0, array.length - 1);
	}

	private T orderStatistics(T[] array, int k, int left, int right) {
		T result = null;
		
		if (left <= right) {
			int i = particionamento(array, left, right);
			if (i == k - 1) {
				result = array[i];
			}
			else if (i > k - 1) {
				result = orderStatistics(array, k, left, i - 1);
			}
				else {
					result = orderStatistics(array, k, i + 1, right);
				}
		}
		
		return result;
	}

	public int particionamento(T[] array, int left, int right) {
		T pivot = array[left];
		int i = left;

		for (int j = left + 1; j <= right; j++) {
			if (array[j].compareTo(pivot) < 0) {
				Util.swap(array, ++i, j);
			}
		}

		Util.swap(array, left, i);
		return i;
	}

	private int indexOf(T[] arr, T v) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].compareTo(v) == 0) {
				return i;
			}
		}
		return -1;
	}
}
