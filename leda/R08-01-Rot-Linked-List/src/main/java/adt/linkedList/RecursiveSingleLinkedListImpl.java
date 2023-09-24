package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null; 
	}

	@Override
	public int size() {
		return size(0);
	}

	private int size(int sum) { // Método privado para ser usado recursivamente.
		int result = sum;
		if (this.data == null) {
			result = 0;
		} else {
			result = 1 + this.next.size(sum);
		}

		return result;
	}

	@Override
	public T search(T element) {
		T result = null;
		if (!isEmpty() && element != null) {
			if (this.getData().equals(element)) {
				result = element;
			} else {
				result = this.next.search(element);
			}
		}
		
		return result;
	}

	@Override
	public void insert(T element) {
		// Refatorar esse código.
		if (element != null) {
			if (this.data == null) { // Se for um ˜nó de lista˜ vazio.
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void remove(T element) {
		if (element != null && !isEmpty()) {
			if (this.data.equals(element)) {
				this.data = getNext().getData();
				this.next = this.next.getNext();
			} else {
				this.next.remove(element);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[size()];
		toArray(result, 0);
		return result;
	}

	// Método para ser usado recursivamente.
	private void toArray(T[] arr, int i) {
		if (this.data != null) { // Enquanto não for vazio vai colocando na lista.
			arr[i] = this.data;
			this.next.toArray(arr, ++i);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
