package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista2.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testInsertFirstEmptyList() {
		((DoubleLinkedList<Integer>) lista3).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista3.toArray());
	}

	@Test
	public void testInsertLastEmptyList() {
		((DoubleLinkedList<Integer>) lista3).insert(4);
		Assert.assertArrayEquals(new Integer[] { 4 }, lista3.toArray());
	}

	@Test
	public void testInsertLastOneElementList() {
		((DoubleLinkedList<Integer>) lista2).insert(4);
		Assert.assertArrayEquals(new Integer[] { 1, 4 }, lista2.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirstOneElementList() {
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { }, lista2.toArray());
	}

	@Test
	public void testRemoveFirstOneTwoElements() {
		lista2.insert(5);
		((DoubleLinkedList<Integer>) lista2).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 5 }, lista2.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	@Test
	public void testRemoveLastTwoElementsList() {
		lista2.insert(5);
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] { 1 }, lista2.toArray());
	}

	@Test
	public void testRemoveLastOneElementList() {
		((DoubleLinkedList<Integer>) lista2).removeLast();
		Assert.assertArrayEquals(new Integer[] { }, lista2.toArray());
	}
}