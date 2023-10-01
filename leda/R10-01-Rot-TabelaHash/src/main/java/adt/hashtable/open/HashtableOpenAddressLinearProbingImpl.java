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
		if (element != null) {
			int probing = 0;
			int hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing);

			while (this.table[hash] != null || this.table[hash].equals(deletedElement)) {
				probing++;
				this.COLLISIONS++;
				hash = ((HashFunctionLinearProbing<T>) this.hashFunction).hash(element, probing);
			}

			if (probing != this.table.length) {
				this.table[hash] = element;
				this.elements++;
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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
