package ordenacao;

import java.util.Scanner;

/* @author Winicius Allan */

class MarianaEOsLivros {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    String[] entrada = input.nextLine().split(",");
    insertionSort(entrada, 0);

    input.close();
  }

  public static void insertionSort(String[] v, int i) {
    System.out.println(showBooks(v));
    if (i == v.length - 1)
      return;
    int j = i + 1;
    while (j > 0 && v[j - 1].compareTo(v[j]) > 0) {
      swap(v, j, j - 1);
      j--;
    }
    insertionSort(v, i + 1);
  }

  public static String showBooks(String[] v) {
    String output = "";
    for (int i = 0; i < v.length; i++) {
      if (i == v.length - 1) {
        output += v[i];
      } else {
        output += v[i] + ", ";
      }
    }
    return output;
  }

  public static void swap(String[] v, int j, int k) {
    String aux = v[j];
    v[j] = v[k];
    v[k] = aux;
  }
}
