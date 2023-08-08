package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator<T> comparadorMaximo;
	private Comparator<T> comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

  private int procuraPorIndice(T o) {
    for (int i = 0; i < arrayInterno.length; i++) {
      if (o.equals(arrayInterno[i])) return i;
    }
    return -1;
  }
	// Insere um objeto no vetor
	public void inserir(T o) {
    if (indice < tamanho) {
      arrayInterno[++indice] = o;
    }
	}

	// Remove um objeto do vetor
	public T remover(T o) {
    T output = null;
    for (int i = 0; i < arrayInterno.length; i++) {
      if (arrayInterno[i].equals(o)) {
        output = arrayInterno[i];
        arrayInterno[i] = arrayInterno[indice];
        arrayInterno[indice] = null; 
        indice--;
      }
    } 
    return output;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
    int indice = procuraPorIndice(o);
    return indice != -1 ? arrayInterno[indice] : null;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
    return indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
    return indice == arrayInterno.length - 1;
	}

}
