import java.util.NoSuchElementException;
import java.util.Scanner;

class FiltraLinkedList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] entrada = converteEntrada(input.nextLine().split(" "));
        LinkedList list = new LinkedList();

        for (int i = 0; i < entrada.length; i++) {
            list.addLast(entrada[i]);
        }

        int num = input.nextInt();
        removeRepetead(list, num);

        if (list.isEmpty()) {
            System.out.println("vazia");
        } else {
            System.out.println(printArray(list.toArray())); 
        }

        input.close();
    }

    public static void removeRepetead(LinkedList lista, int num) {
        Node aux = lista.getTail();
        
        for (int i = lista.getSize() - 1; i >= 0; i--) {
            if (aux.v == num) {
                lista.remove(i);
            }
            aux = aux.prev;
        }
    }

    public static int[] converteEntrada(String[] v) {
        int[] output = new int[v.length];
        for (int i = 0; i < v.length; i++) {
          output[i] = Integer.parseInt(v[i]);
        }
        return output;
    }

    private static String printArray(int[] v) {
        String output = "";
        for (int num : v) {
            output += num + " ";
        }
        return output.trim();
    }
}

class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }

        if (index == 0) {
            this.addFirst(value);
        } else if (index == size - 1) {
            this.addLast(value);
        } else {
            Node newNode = new Node(value);
    
            // Criamos um nó auxiliar pra poder iterar na lista. Fazemos isso para não perder a referência do head.
            Node aux = this.head;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            newNode.next = aux.next;
            aux.next = newNode;
    
            size++;
        }

    }

    public void addLast(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }

        size++;
    }

    public void addFirst(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        size++;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node aux = this.head;
        for (int i = 0; i < index; i++) {
            aux = aux.next;
        }

        return aux.v;
    }

    public int indexOf(int value) {
        Node aux = this.head;

        int i = 0;
        while (aux != null) {
            if (aux.v == value) {
                return i;
            }
            aux = aux.next;
            i++;
        }

        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int remove(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(index);
        }
        
        if (index == 0) {
            return this.removeFirst();
        } else if (index == this.size - 1) {
            return this.removeLast();
        } else {
            Node aux = this.head;
            for (int i = 0; i < index; i++) {
                aux = aux.next;
            }
            aux.prev.next = aux.next;
            aux.next.prev = aux.prev;
            this.size--;

            return aux.v;
        }
    }

    public int removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        int result = this.head.v;
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }

        this.size--;
        return result;
    }

    public int removeLast() {
        if (isEmpty()) throw new NoSuchElementException();

        int result = this.tail.v;
        if (this.head.next == null) { // Caso a lista só tenha um elemento.
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        this.size--;
        return result;
    }
    
    public Node getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
    }

    public Node getTail() {
        return this.tail;
    }

    public int[] toArray() {
        int[] arr = new int[this.size];

        Node aux = this.head;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux.v;
            aux = aux.next;
        }

        return arr;
    }
}

class Node {
    
    public Node next;
    public Node prev;
    public int v;

    public Node(int v) {
        this.v = v;
        this.next = null;
    }
}
