package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) throw new HashtableOverflowException();

		if (element != null) {
			boolean found = false;
			int probing = 0;
			int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probing);

			while (this.table[hash] != null && !this.table[hash].equals(this.deletedElement)) {
				this.COLLISIONS++;

				if (this.table[hash].equals(element)) {
					found = true;
					break;
				}

				probing++;
				hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probing);
			}

			if (!found) {
				this.table[hash] = element;
				elements++;
			}		
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			int index = indexOf(element);

			if (index != -1) { // Elemento existe.
				table[index] = this.deletedElement;
				--elements;
			}
		}
	}

	@Override
	public T search(T element) {
		T result = null;

		if (element != null) {
			int probing = 0;
			
			while (probing < this.table.length) {
				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probing);

				if (this.table[hash] != null && this.table[hash].equals(element)) {
					result = element;
				}

				probing++;
			}
		}

		return result;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;

		if (element != null) {
			int probing = 0;
			
			while (index == -1 && probing < this.table.length) { // Enquanto não tiver achado o elemento e o probing for menor que a tabela.
				int hash = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probing);

				if (table[hash] != null && table[hash].equals(element)) {
					index = hash;
				} else {
					probing++;
				}
			}
		}

		return index;
	}
}
