class ArrayList {
    
    private int[] arr;
    private static int CAPACIDADE_DEFAULT = 10;
    private int tamanho; // Atributo que controla a quantidade de elementos presente na lista.

    public ArrayList() {
        this(CAPACIDADE_DEFAULT);
    }

    public ArrayList(int capacidade) {
        this.arr = new int[capacidade];
        this.tamanho = 0;
    }

    /**
     * Maneiras de adicionar um elemento no ArrayList:
     * boolean add(int v);
     * void add(int index, int v); Adiciona no index.
     * void set(int index, int v); Sobescreve o elemento no index.
     */
    public void add(int v) { // O(1) amortizado
        ensureCapacity(this.arr.length + 1); // Verificar se há espaço no array
        this.arr[tamanho++] = v;
    }

    public void add(int index, int v) {
        if (index < 0 || index > this.arr.length - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }

        ensureCapacity(this.arr.length + 1);        
        shiftPraDireita(index);

        this.arr[index] = v;
        tamanho++;
    }

    public void set(int index, int v) {
        if (index < 0 || index > this.arr.length - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }

        this.arr[index] = v;
    }

    public void remove(int index) {
        if (index < 0 || index >= tamanho) {
            throw new IllegalArgumentException("Índice inválido");
        }

        shiftParaEsquerda(index);
        tamanho--;
    }

    public int size() {
        return tamanho;
    }

    private void shiftPraDireita(int index) {
        if (index == this.arr.length - 1) {
            throw new IndexOutOfBoundsException("Índice inválido para shift");
        }

        for (int i = tamanho; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }
    }

    private void shiftParaEsquerda(int index) {
        for (int i = index; i < this.tamanho; i++) {
            this.arr[i] = this.arr[i + 1];
        }
    }

    private void ensureCapacity(int capacity) {
        if (capacity > this.arr.length) {
            resize(Math.max(capacity, this.arr.length * 2));
        }
    }

    private void resize(int capacity) { // O(n)
        int[] newArr = new int[capacity];
        for (int i = 0; i < this.arr.length; i++) {
            newArr[i] = arr[i];
        }
        this.arr = newArr;
    }

   
}
