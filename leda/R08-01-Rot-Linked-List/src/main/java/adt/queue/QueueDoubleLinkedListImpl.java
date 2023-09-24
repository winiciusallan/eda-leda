package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		if (element != null) {
			this.list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;

		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			result = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
			this.list.removeFirst();	
		}

		return result;
	}

	@Override
	public T head() {
		T result = null;
		if (!isEmpty()) {
			result = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		}

		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.list.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.list.size() == this.size;
	}

}
