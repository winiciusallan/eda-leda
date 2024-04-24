package ordenacao;

import java.util.Arrays;
import java.util.Scanner;

public class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] arrInput = input.nextLine().split(" ");
        int[] arr = new int[arrInput.length];

        for (int i = 0; i < arrInput.length; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        // for (int i = 0; i < arr.length - 1; i++) {
        //     if (i % 2 == 0) { swap(i, i + 1, arr); }
        // }
        trocaVizinhosRecursive(arr, 0);

        System.out.println(Arrays.toString(arr));
        input.close();
    }

    private static void trocaVizinhosRecursive(int[] arr, int i) {
        if (i == arr.length - 1 || arr.length == 0) return;

        if (i % 2 == 0) {
            swap(i, i+1, arr);
        }
        trocaVizinhosRecursive(arr, i+1);
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}