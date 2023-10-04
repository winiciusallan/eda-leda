package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if (isFull()) throw new HashtableOverflowException();

		if (element != null) {
			boolean found = false;
			int probing = 0;
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing);

			while (this.table[hash] != null && !this.table[hash].equals(this.deletedElement)) {
				this.COLLISIONS++;

				if (this.table[hash].equals(element)) {
					found = true;
					break;
				}

				probing++;
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing);
			}

			if (!found) {
				this.table[hash] = element;
				elements++;
			}

			
		}
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T search(T element) {
		T result = null;

		if (element != null) {
			int probing = 0;
			
			while (probing < this.table.length) {
				int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing);

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
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing);

			while (this.table[hash] != element || probing < this.table.length) {
				probing++;
			}

			index = hash;

		}

		return index;
	}

}
