package recursao;

/* @author Winicius Allan */

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array, int index){
		int soma = 0;
		if (index == array.length) { 
			return 0; 
		}
		soma += array[index] + calcularSomaArray(array, index + 1);
		return soma;
	}
	public long calcularFatorial(int n) {
		if (n == 0) { return 1; }
		return n * calcularFatorial(n - 1);
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR E IMPRIMIR
		// O N-ESIMO TERMO
		// DA SEQUENCIA DE FIBONACCI, QUE TEM A SEGUINTE LEI DE FORMACAO: O
		// PRIMEIRO E SEGUNDO NUMEROS
		// DA SEQUENCIA SÃO 1. A PARTIR DO TERCEIRO TERMO, CADA TERMO DA
		// SEQUENCIA É DADO
		// PELA SOMA DOS OUTROS DOIS ANTERIORES. OBSERVE QUE SENDO O METODO
		// RECURSIVO, O FIBONACCI DOS NUMEROS ANTERIORES TAMBEM VAO SER
		// IMPRESSOS
		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		// TODO IMPLEMENTE AQUI O CODIGO QUE CONTA (USANDO RECURSAO) A
		// QUANTIDADE DE ELEMENTOS NAO NULOS
		// DE UM ARRAY DE OBJETOS RECEBIDO COMO PARAMETRO
		return result;
	}

	public long potenciaDe2(int expoente) {
		int result = 2;
		if (expoente == 0) { return 1; }
		return result * potenciaDe2(expoente - 1);
	}

	// Dúvida caso base.
	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n == 1) { 
			return result;
		}
		result = razao + progressaoAritmetica(termoInicial, razao, n - 1);
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		// VOCE NAO PODE USAR A FORMULA QUE CALCULA O N-ESIMO TERMO. DEVE USAR RECURSAO
		return result;
	}
}
