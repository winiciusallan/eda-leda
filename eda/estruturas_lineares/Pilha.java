class Pilha {

    private int[] pilha;
    private int top;

    public Pilha(int capacidade) {
        this.pilha = new int[capacidade];
        this.top = -1;
    }

    public Pilha(int[] v, int capacidade) {
        this.pilha = v;
    }

    public void push(int n) {
        if (isFull()) throw new StackOverflowError("Stack overflow");

        this.pilha[++top] = n;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        int valorTopo = this.pilha[top];
        top--;
        return valorTopo;
    }

    public int pop(int index) {
        Pilha aux = new Pilha(this.size());
        if (index > top || index < 0) throw new IllegalArgumentException("Índice inválido");

        while (top > index) {
            aux.push(this.pop());
        }
        int value = this.peek();
        while (aux.size() > 0) {
            this.push(aux.pop());
        }
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");

        return this.pilha[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity() - 1;
    }

    public int capacity() {
        return pilha.length;
    }

    public int size() {
        return (this.top + 1);
    }

    public int[] getPilha() {
        int[] output = new int[this.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = pilha[i];
        }
        return output;
    }
}