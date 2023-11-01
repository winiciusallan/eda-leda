import java.util.Arrays;

public class Heap {
    // Estrutura interna
    public int[] heap;
    public int tail;

    public Heap(int size) {
        this.heap = new int[size];
        this.tail = -1;
    }

    public Heap(int[] array) {
        this.heap = array;
        this.tail = this.heap.length - 1;
        this.buildHeap();
  }

    // Métodos essenciais
    public boolean isEmpty() {
        return this.tail == -1;
    }

    public int size() {
        return this.tail + 1;
    }

    /**A adição de um novo elemento sempre é feita na próxima posição livre do array. Essa estratégia garante que o Heap
     * sempre será completo ou quase completo da esquerda para a direita. Contudo, precisamos corrigir o risco de quebrar
     * a propriedade de ter sempre valores maiores acima de cada nó na árvore.
     * Eficiência: No pior caso, o caminho percorrido é igual ao tamanho da altura, que é sempre log(n)
     * @param el novo elemento a ser inserido no Heap
     */
    public void add(int el) {
        if (this.tail + 1 == this.heap.length) {
           resize();
        }  

        heap[++this.tail] = el;

        int i = this.tail;
        while (i > 0 && heap[i] > heap[parent(i)]) {
            swap(parent(i)), i);
            i = parent(i);
        }
    }

    /** A remoção em um Heap não é parametrizada, tendo em vista que ela é feita sempre na raiz. Para manter a propriedade
     * de completude, trocamos a raiz com o último nó folha e o removemos. Em seguida, aplicamos o heapify para que a
     * propriedade de valores abaixo serem sempre menores. Sequencialmante, aplica-se a regra de "maior dos três" com o pai
     * iniciando na raiz e comparando-o com seus dois possíveis filhos.
     * Eficiência: No pior caso, o heapify é executado até as folhas, de modo que a remoção no heap tem eficiência log(n)
     * @return o elemento removido
     */

    public int remove() {
        if (!isEmpty()) {
            int result = this.heap[0];
            swap(0, this.tail--)

            heapify(0) 
        }
    }

    // Métodos de acesso a nós relacionados
    public int left(int i) {
        return i * 2 + 1;
    }

    public int right(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    // Métodos auxiliares
    /**Via de regra numa árvore balanceada, se o índice de um nó for maior que o do pai da cauda, esse nó é uma folha
     *
     * @param index o índice do qual se deseja saber se é folha
     */
    private boolean isLeaf(int index) {
        return index > parent(tail) && index <= tail;
    }

    private void resize() {
        int[] newHeap = new int[this.heap.length * 2];
        for (int i = 0; i <= tail; i++) {
            newHeap[i] = this.heap[i];
        }

        this.heap = newHeap;
    }

    private void buildHeap() {
        int index = this.tail;
        for (int i = parent(index); i >= 0; i--) { // Começar com o parent do tail para evitar aplicar o heapify nas folhas.
            heapify(i);
        }
    }

    private void heapify(int index) {
        /**
         * O heapify precisa de um parâmetro index porque a gente tem que realizar trocas enquanto não for garatida a pro-
         * priedade de que todo valor é maior que seus filhos. Sendo assim, temos que aplicar essa função recursivamente,
         * comparando o pai com seus filhos. Logo, precisamos do índice do pai. A condição de parada é alcançar um nó folha
         * (que não tem filhos) ou ter recebido um índice inválido.
         * @param index
         */
        if (isLeaf() || !isValidIndex()) return;

        int indexMax = maxIndex(index, left(index), right(index));

        if (indexMax != index) {
            swap(index, indexMax);
            heapify(indexMax);
        }
    }



    private void swap(int i, int j) {
        System.out.println("swapping "+ i + " and "+ j);
        int aux = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = aux;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index <= tail;
    }

    private int maxIndex(int index, int left, int right) {
        if (this.heap[index] > this.heap[left]) {
            if (isValidIndex(right)){
                if (this.heap[right] > this.heap[index]) {
                    return right;
                }
            }
            return index;
        } else {
            if (isValidIndex(right)) {
                if (this.heap[left] > this.heap[right]) {
                    return left;
                }
            }
            return right;
        }
    }

    public String toString() {
        return Arrays.toString(this.heap);
    }
}
