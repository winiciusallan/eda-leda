public class LinkedList {

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
            this.head = newNode;
        }
        size++;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(index);
        }

        Node aux = this.head;
        for (int i = 0; i <=index; i++) {
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
        return 0;
    }

    public int removeFirst() {
        return 0;
    }

    public int removeLast() {

        int result = this.tail.v;
        if (this.head.next == null) { // Caso a lista só tenha um elemento.
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }

        size--;
        return result;
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