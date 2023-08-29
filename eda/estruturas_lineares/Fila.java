package estruturas_lineares;

class Fila {
    
    private int[] fila;
    private int tail;
    private int head;
    private int capacidade;

    public Fila() {
        this(10);
    }

    public Fila(int capacidade) {
        this.fila = new int[capacidade];
        this.tail = -1;
        this.head = -1;
        this.capacidade = capacidade;
    }

    public void add(int n) {
        if (isFull()) throw new RuntimeException("Fila cheia");
        if (isEmpty()) {
            head++;
            this.fila[++tail] = n;
        } else {
            tail = (tail + 1) % capacidade;
            this.fila[tail] = n;
        }
    }

    public void remove() {
        if (isEmpty()) throw new RuntimeException("Fila vazia");

        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = head + 1 % capacidade;
        }
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Fila vazia");
        return fila[head];
    }

    public int size() {
        
    }

    private boolean isEmpty() {
        return tail == -1 && head == -1;
    }

    private boolean isFull() {
        return ((this.tail + 1) % capacidade) == this.head;
    }

}
