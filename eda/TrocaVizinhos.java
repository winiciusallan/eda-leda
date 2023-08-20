import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String[] arrInput = input.nextLine().split(" ");
        int[] arr = new int[arrInput.length];

        for (int i = 0; i < arrInput.length; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) { swap(i, i + 1, arr); }
        }

        System.out.println(Arrays.toString(arr));
        input.close();
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}