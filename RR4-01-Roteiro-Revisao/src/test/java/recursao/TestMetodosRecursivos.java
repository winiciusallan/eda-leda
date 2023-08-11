package recursao;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Assert.*;


public class TestMetodosRecursivos {

	private MetodosRecursivos metodosRecursivos;

	@Before
	public void setUp() {
		this.metodosRecursivos = new MetodosRecursivos();
	}	

	@Test
	public void calcularFatorial() {
		assertEquals(120, metodosRecursivos.calcularFatorial(5));
		assertEquals(6,	metodosRecursivos.calcularFatorial(3));
		assertEquals(1, metodosRecursivos.calcularFatorial(0));
	}

	@Test
	public void calculaSomaArray() {
		assertEquals(12, metodosRecursivos.calcularSomaArray(new int[]{3, 7, 2}, 0));
		assertEquals(21, metodosRecursivos.calcularSomaArray(new int[]{9, 2, 1, 4, 5}, 0));
		assertEquals(0, metodosRecursivos.calcularSomaArray(new int[]{}, 0));
	}

	@Test
	public void potenciaDe2() {
		assertEquals(256, metodosRecursivos.potenciaDe2(8));
		assertEquals(8, metodosRecursivos.potenciaDe2(3));
		assertEquals(1, metodosRecursivos.potenciaDe2(0));
	}

	@Test
	public void progressaoAritmetica() {
		assertEquals(8, (int) metodosRecursivos.progressaoAritmetica(0, 2, 5));
	}
}
