package estruturas_lineares;
import java.util.Scanner;

class InvertePilhaIndex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int tam = input.nextInt();
        input.nextLine();
        int[] entrada = converteEntrada(input.nextLine().split(" "));
        int index = input.nextInt();
        Pilha pilha = new Pilha(tam);
        for (int i = tam - 1; i >= 0; i--) {
            pilha.push(entrada[i]);
        }

        System.out.println("-");

        Pilha result = new Pilha(tam); // Pilha final com os elementos invertidos.
        Pilha aux = new Pilha(tam); // Pilha auxiliar para guardar os elementos que serão invertidos.
        for (int i = 0; i < pilha.capacity(); i++) {
            if (i < (pilha.capacity() - 1 - index)) {
                result.push(pilha.pop());
            } else {
                aux.push(pilha.pop());
            }
        }

        for (int i = 0; i <= index; i++) {
            result.push(aux.pop());
        }

        printArray(result);
    }

    private static void printArray(Pilha p) {
        for (int i = 0; i < p.capacity(); i++) {
            System.out.println(p.pop());
        }
    }

    private static int[] converteEntrada(String[] v) {
        int[] output = new int[v.length];
        for (int i = 0; i < v.length; i++) {
          output[i] = Integer.parseInt(v[i]);
        }
        return output;
    }
}

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
