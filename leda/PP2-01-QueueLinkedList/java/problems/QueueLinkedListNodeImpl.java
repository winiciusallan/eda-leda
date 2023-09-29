package problems;

import adt.linkedList.SingleLinkedListNode;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;


public class QueueLinkedListNodeImpl<T> implements QueueLinkedListNode<T>{

    private SingleLinkedListNode<T> head;
    private SingleLinkedListNode<T> tail;
    private int capacity;
    private int size;

    /**
     * Construtor da classe. Esse construtor precisa existir.
     * Restricao:
     * - NÃO altere a assinatura desse construtor. 
     *   Voce pode ajustar apenas o corpo do construtor, se necessário.
     */
    public QueueLinkedListNodeImpl(int size){
        this.head = new SingleLinkedListNode<>();
        this.tail = new SingleLinkedListNode<>();
        this.capacity = size;
    }

    public void enqueue(T element) throws QueueOverflowException{
        if (isFull()) {
            throw new QueueOverflowException();
        }

        if (element != null) {
            SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<T>());
            if (isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.setNext(newNode);
                this.tail = newNode;
            }
            
            size++;
        }
    }

	public T dequeue() throws QueueUnderflowException{
        if (isEmpty()) {
            throw new QueueUnderflowException();
        }

        T result = this.head.getData();

        if (this.head.getNext().isNIL()) { // Tiver apenas um elemento.
            this.head = new SingleLinkedListNode<>();
            this.tail = new SingleLinkedListNode<>();
        } else {
            this.head = this.head.getNext();
        }

        size--;

        return result;
    }

	public T head(){
        return this.head.getData();
    }

	public boolean isEmpty(){
        return this.head.isNIL();
    }

	public boolean isFull(){
        return this.size == this.capacity;
    }

    public int size(){
        return this.size;
    }

}
