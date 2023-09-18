package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> emptyQueue;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueUsingStack<>(6);
		queue2 = new QueueUsingStack<>(2);
		queue3 = new QueueUsingStack<>(5);
		emptyQueue = new QueueUsingStack<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFullCircular() throws QueueOverflowException, QueueUnderflowException {
		assertTrue(queue2.isFull());

		queue1.enqueue(4);
		queue1.enqueue(3);
		queue1.enqueue(9);
		Integer a = queue1.dequeue();
		a = queue1.dequeue();

		queue1.enqueue(6);
		queue1.enqueue(2);

		assertTrue(queue1.isFull());
		assertEquals(3, (int) queue1.head());;
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDequeueNull() {
		try {
			assertEquals(null, emptyQueue.dequeue());
		} catch (QueueUnderflowException e) {
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), emptyQueue.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	@Test
	public void testGetNullHead() {
		assertEquals(null, emptyQueue.head());
	}

	@Test
	public void testDequeueWithShift() throws QueueUnderflowException {
		if (queue1 instanceof QueueImpl) {
			Integer v = queue1.dequeue();
			assertEquals(2, (int) queue1.head());
		}
	}
}