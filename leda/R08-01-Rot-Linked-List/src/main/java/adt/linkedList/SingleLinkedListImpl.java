package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;

		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = getHead();
	
			while (!aux.isNIL()) {
				aux = aux.next;
				size++;
			}
		}

		return size;
	}

	@Override
	public T search(T element) {
		T result = null;

		if (!isEmpty() && element != null) {
			SingleLinkedListNode<T> aux = getHead();
	
			while (!aux.next.isNIL()) {
				if (aux.getData().equals(element)) {
					result = aux.getData();
				}
				aux = aux.next;
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			SingleLinkedListNode<T> aux = getHead();
	
			if (isEmpty()) {
				setHead(newNode);
			} else {
				while (!aux.next.isNIL()) {
					aux = aux.next;
				}
	
				aux.next = newNode;
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {

			if (size() == 1) {
				setHead(new SingleLinkedListNode<>());
			} else {
				SingleLinkedListNode<T> aux = getHead();
	
				while (!aux.next.getData().equals(element)) {
					aux = aux.next;
				}
	
				aux.next = aux.next.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];

		SingleLinkedListNode<T> aux = getHead();

		int i = 0;
		if (!isEmpty()) {
			while (!aux.isNIL()) {
				result[i] = aux.getData();
				aux = aux.next; 
				i++;
			}
		}

		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
