package ordenacao;
import java.util.Arrays;
import java.util.Scanner;

class SelectionSortRecursivo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] entrada = converteEntrada(input.nextLine().split(" "));
        
        selectionSort(entrada, 0);
        input.close();
    }

    public static void selectionSort(int[] v, int i) {
        if (i == v.length - 1) return;
        int indiceMenor = i;
        for (int j = i + 1; j < v.length; j++) {
            if (v[j] < v[indiceMenor]) {
                indiceMenor = j;
            }
        }
        swap(v, i, indiceMenor);
        System.out.println(Arrays.toString(v));
        selectionSort(v, i + 1);
    }
    public static int[] converteEntrada(String[] v) {
        int[] output = new int[v.length];
        for (int i = 0; i < v.length; i++) {
        output[i] = Integer.parseInt(v[i]);
        }
        return output;
    }

    public static void swap(int[] v, int j, int k) {
        int aux = v[j];
        v[j] = v[k];
        v[k] = aux;
    }
}
