package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		if (isEmpty()) {
			head++;
			this.array[++tail] = element;
		} else {
			// Linha que torna o vetor circular. O uso do modulo faz com que nosso tail circule.
			tail = (tail + 1) % this.array.length;
			this.array[tail] = element;
			elements++;
		}

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		if (head == tail) {
			result = this.array[head];
			head = -1;
			tail = -1;
		} else {
			head = (head + 1) % this.array.length;
			result = this.array[head];
			elements--;
		}

		return result;
	}

	@Override
	public T head() {
		T result = null;
		if (!isEmpty()) {
			result = this.array[head];
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.head == -1 && this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return ((this.tail + 1) % this.array.length) == head;
	}

}
