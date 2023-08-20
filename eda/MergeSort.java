import java.util.Arrays;
import java.util.Scanner;

class MergeSort {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int[] entrada = converteEntrada(input.nextLine().split(" "));
    mergeSort(entrada, 0, entrada.length - 1);
    
  }

  public static void mergeSort(int[] v, int left, int right) {
    arrayInRange(v, left, right);
    if (!(left >= right)) {
      int meio = (left + right) / 2;
      
      mergeSort(v, left, meio);
      mergeSort(v, meio + 1, right);
      
      merge(v, left, right);
    }
  }

  private static void merge(int[] v, int left, int right) {
    int[] helper = new int[v.length];
    for (int i = 0; i < helper.length; i++) {
      helper[i] = v[i];
    }

    int i = left;
    int meio = (left + right) / 2;
    int j = meio + 1;
    int k = left;

    while (i <= meio && j <= right) {
      if (helper[i] < helper[j]) {
        v[k] = helper[i];
        i++;
      } else {
        v[k] = helper[j];
        j++;
      }
      k++;
    }

    while (i <= meio) {
      v[k] = helper[i];
      i++;
      k++;
    }

    while (j <= right) {
      v[k] = helper[j];
      j++;
      k++;
    }
    arrayInRange(v, left, right);
  }

  public static int[] converteEntrada(String[] v) {
      int[] output = new int[v.length];
      for (int i = 0; i < v.length; i++) {
        output[i] = Integer.parseInt(v[i]);
      }
      return output;
  }

  public static void arrayInRange(int[] v, int left, int right) {
    int[] output = new int[right - left + 1];
    for (int i = 0; i < output.length; i++) {
      output[i] = v[i + left];
    }
    System.out.println(Arrays.toString(output));
  }
}
