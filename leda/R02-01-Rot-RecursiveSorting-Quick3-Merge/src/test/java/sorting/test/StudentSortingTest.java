package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	private Integer[] vetorUmElemento;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });
		populaVetorUmElemento(new Integer[] { 1 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.implementation = new HybridMergeSort<Integer>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorUmElemento(Integer[] arrayPadrao) {
		this.vetorUmElemento = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	public void sortAndVerifyQuantity(Integer[] array, int insertionQuantity, int mergeQuantity) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		HybridMergeSort converedImplementation = (HybridMergeSort) implementation;
		Assert.assertArrayEquals(copy1, array);
		Assert.assertEquals(mergeQuantity, converedImplementation.getMergeSortAplications());
		Assert.assertEquals(insertionQuantity, converedImplementation.getInsertionSortAplications());
	}

	public void sortToTheMiddle(Integer[] array) {
		Integer[] copy1 = new Integer[array.length];
		if (array.length > 0) {
			for (int i = 0; i <= (int) Math.ceil(array.length / 2); i++) {
				copy1[i] = array[i];
			}

			Arrays.sort(copy1, 0, (int) Math.ceil(array.length / 2) + 1);

			for (int i = (int) Math.ceil(array.length / 2) + 1; i < array.length; i++) {
				copy1[i] = array[i];
			}
			implementation.sort(array, 0, (int) Math.ceil(array.length / 2));
		}
		Assert.assertArrayEquals(copy1, array);
	}

	public void sortFromMiddleToTheEnd(Integer[] array) {
		Integer[] copy1 = new Integer[array.length];
		if (array.length > 0) {
			for (int i = (int) Math.ceil(array.length / 2); i < array.length; i++) {
				copy1[i] = array[i];
			}

			Arrays.sort(copy1, (int) Math.ceil(array.length / 2), array.length);

			for (int i = 0; i < (int) Math.ceil(array.length / 2); i++) {
				copy1[i] = array[i];
			}

			implementation.sort(array, (int) Math.ceil(array.length / 2), array.length - 1);
		}

		Assert.assertArrayEquals(copy1, array);
	}

	public void sortOutOfBound(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, 0, array.length);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	@Test
	public void testSort06() {
		genericTest(vetorUmElemento);
	}

	@Test
	public void testSort07() {
		sortToTheMiddle(vetorTamPar);
	}

	@Test
	public void testSort08() {
		sortToTheMiddle(vetorTamImpar);
	}

	@Test
	public void testSort09() {
		sortToTheMiddle(vetorVazio);
	}

	@Test
	public void testSort10() {
		sortToTheMiddle(vetorValoresIguais);
	}

	@Test
	public void testSort11() {
		sortToTheMiddle(vetorValoresRepetidos);
	}

	@Test
	public void testSort12() {
		sortToTheMiddle(vetorUmElemento);
	}

	@Test
	public void testSort13() {
		sortOutOfBound(vetorTamPar);
	}

	@Test
	public void testSort14() {
		sortOutOfBound(vetorTamImpar);
	}

	@Test
	public void testSort15() {
		sortOutOfBound(vetorVazio);
	}

	@Test
	public void testSort16() {
		sortOutOfBound(vetorValoresIguais);
	}

	@Test
	public void testSort17() {
		sortOutOfBound(vetorValoresRepetidos);
	}

	@Test
	public void testSort18() {
		sortOutOfBound(vetorUmElemento);
	}

	@Test
	public void testSort19() {
		sortAndVerifyQuantity(vetorTamPar, 2, 1);
	}

	@Test
	public void testSort20() {
		sortAndVerifyQuantity(vetorTamImpar, 3, 2);
	}

	@Test
	public void testSort21() {
		sortAndVerifyQuantity(vetorVazio, 0, 0);
	}

	@Test
	public void testSort22() {
		sortAndVerifyQuantity(vetorValoresIguais, 2, 1);
	}

	@Test
	public void testSort23() {
		sortAndVerifyQuantity(vetorValoresRepetidos, 2, 1);
	}

	@Test
	public void testSort24() {
		sortAndVerifyQuantity(vetorUmElemento, 0, 0);
	}

	@Test
	public void testSort25() {
		sortFromMiddleToTheEnd(vetorTamPar);
	}

	@Test
	public void testSort26() {
		sortFromMiddleToTheEnd(vetorTamImpar);
	}

	@Test
	public void testSort27() {
		sortFromMiddleToTheEnd(vetorVazio);
	}

	@Test
	public void testSort28() {
		sortFromMiddleToTheEnd(vetorValoresIguais);
	}

	@Test
	public void testSort29() {
		sortFromMiddleToTheEnd(vetorValoresRepetidos);
	}

	@Test
	public void testSort30() {
		sortFromMiddleToTheEnd(vetorUmElemento);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
}