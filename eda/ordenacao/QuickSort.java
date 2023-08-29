package ordenacao;
import java.util.Scanner;

class QuickSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] entrada = converteEntrada(input.nextLine().split(" "));
        quickSort(entrada, 0, entrada.length - 1);

        input.close();
    }

    public static void quickSort(int[] v, int left, int right) {
        if (left < right) {
            int indicePivot = particionamento(v, left, right);
            quickSort(v, left, indicePivot - 1); // Faz o particionamento para os elementos antes do pivot.
            quickSort(v, indicePivot + 1, right); // Faz o particionamento para os elementos depois do pivot.
        }
    }

    public static int particionamento(int[] v, int left, int right) {
        int pivot = v[left]; // O pivot controla os elementos que serão menores (à esquerda) e os que serão maiores (à direita).
        int i = left;
        
        for (int j = left + 1; j < v.length; j++) {
            if (v[j] < pivot) {
                i++;
                swap(v, i, j);
            }
        }
        swap(v, left, i); // Trocar o pivot com o último índice de controle.
        System.out.println(printArray(v, left, right));
        return i;
    }

    public static void swap(int[] v, int i, int j) {
        int aux = v[i];
        v[i] = v[j];
        v[j] = aux;
    }

    public static int[] converteEntrada(String[] v) {
        int[] output = new int[v.length];
        for (int i = 0; i < v.length; i++) {
          output[i] = Integer.parseInt(v[i]);
        }
        return output;
    }

    public static String printArray(int[] v, int left, int right) {
        String output = "";
        for (int i = 0; i < v.length; i++) {
            if (i == v.length - 1) {
                output += v[i];
            } else {
                output += v[i] + " ";
            }
        }
        return output;
  }
}