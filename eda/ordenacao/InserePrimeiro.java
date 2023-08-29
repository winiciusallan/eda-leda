package ordenacao;
import java.util.Arrays;
import java.util.Scanner;

class InserePrimeiro {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String[] entradaTemp = input.nextLine().split(" ");
    int[] entrada = converteEntrada(entradaTemp);

    insercaoOrdenadaPrimeiro(entrada);
    System.out.println(Arrays.toString(entrada));
  }

  public static void insercaoOrdenadaPrimeiro(int[] v) {
    int i = 0;
    while (i < v.length - 1 && v[i] > v[i + 1]) {
      swap(v, i, i + 1);
      i++;
    }
  }
  public static void swap(int[] v, int j, int k) {
    int aux = v[j];
    v[j] = v[k];
    v[k] = aux;
  }

  public static int[] converteEntrada(String[] v) {
    int[] output = new int[v.length];
    for (int i = 0; i < v.length; i++) {
      output[i] = Integer.parseInt(v[i]);
    }
    return output;
  }
}
