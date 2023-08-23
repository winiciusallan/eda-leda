package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Voce NÃO pode modificar o aray original
	 * - Voce NÃO pode usar memória extra: nenhum array auxiliar deve ser criado e utilizado.
	 * - Você NÃO pode usar métodos já prontos de manipulação de arrays
	 * - Voce NÃO pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   usando a ideia do selection sort).
	 * - Considere que k varia de 1 a N 
	 * - Voce DEVE usar recursão para resolver o problema. Nenhum laço poderá ser utilizado.
	 * - Você pode implementar métodos auxiliares, desde que seja apenas nesta classe.
	 * - Os métodos auxiliares NÃO PODEM ter mais que três parâmetros.
	 *
	 * Dica: procure pensar como usar a ideia do selection sort para resolver esse problema,
     *       identifique que métodos você precisará para resolver o problema 
	 *       e pense no template da recursão em cada método que voce vai implementar.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if (k == 1) {
			return getMinor(array, array[0], 0);
		}

		T menor = null;
		for (int i = 0; i < k; i++) {
			menor = getBiggerThanMinor(array, array[0], 0);
		}
		
		return menor;
	}

	private T getMinor(T[] array, T menor, int i) {
		if (i < array.length) {
			if (array[i].compareTo(menor) < 0) {
				menor = array[i];
			}
			return getMinor(array, menor, ++i);
		}

		return menor;
	}

	private T getBiggerThanMinor(T[] array, T menor, int i) {
		T menorDeTodos = getMinor(array, array[0], 0);
		if (i < array.length) {
			if (array[i].compareTo(menor) < 0 && array[i].compareTo(menorDeTodos) > 0) {
				menor = array[i];
				menorDeTodos = array[i];
			}
			return getBiggerThanMinor(array, menor, ++i);
		}

		return menor;
	}

	private T kthSmallest(T[] array, T kthMinor, int i) {
		T menorDeTodos = getMinor(array, array[0], 0);
		return menorDeTodos;
	}
}
