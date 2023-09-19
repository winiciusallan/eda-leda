package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		super.head = new DoubleLinkedListNode<T>();
		this.last = new DoubleLinkedListNode<T>();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.last = new DoubleLinkedListNode<T>(element,
				new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());

				this.head = this.last;
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(element,
				new DoubleLinkedListNode<>(), this.last);
	
				this.last.next = newNode;
				setLast(newNode);
			}
		}
	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.insert(element);
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element,
				getHead(), new DoubleLinkedListNode<>());
				getHead().setPrevious(newNode);
				setHead(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			if (size() == 1) {
				this.last = new DoubleLinkedListNode<T>();
				this.head = this.last;
			} else {
				this.head = head.next;
				((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (size() == 1) {
				this.removeFirst();
			} else {
				this.last = this.last.getPrevious();
				this.last.setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public T search(T element) {
		// To be implemented!!
		return null;
	}

	@Override
	public DoubleLinkedListNode<T> getHead() {
		return (DoubleLinkedListNode<T>) this.head;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
