import java.util.Arrays;
import java.util.Scanner;

class InsertionSortRecursivo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] entrada = converteEntrada(input.nextLine().split(" "));
        insertionSort(entrada, 0);
    }
    
    public static void insertionSort(int[] v, int i) {
        if (i == v.length - 1) return;
        int j = i + 1;
        while (j > 0 && v[j] < v[j - 1]) {
            swap(v, j, j - 1);
            j--;
        }
        System.out.println(Arrays.toString(v));
        insertionSort(v, i + 1);
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



