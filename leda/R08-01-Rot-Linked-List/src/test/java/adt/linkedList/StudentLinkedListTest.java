package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());

	}

	@Test
	public void testToArrayRemovingElements() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(1);
		assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	@Test
	public void testToArrayRemovingElementsInMiddle() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		assertArrayEquals(new Integer[] { 3, 1 }, lista1.toArray());
	}

	@Test
	public void testToArrayRemoveListOneElement() {
		Assert.assertEquals(3, lista1.size());
		lista2.insert(2);
		lista2.remove(2);
		assertArrayEquals(new Integer[] { }, lista2.toArray());
	}

	@Test
	public void testToArrayRemoveElementNotInList() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(4);
		assertArrayEquals(new Integer[] { 3, 2, 1}, lista2.toArray());
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}
}