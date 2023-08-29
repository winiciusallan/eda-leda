package ordenacao;
import java.util.Scanner;

class MelhorPivot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] entrada = converteEntrada(input.nextLine().split(" "));
        int[] nums = converteEntrada(input.nextLine().split(" "));
        int i = nums[0], j = nums[1];

        System.out.println(melhorPivot(entrada, i, j));
    }
    
    private static int melhorPivot(int[] v, int i, int j) {
        swap(v, 0, i);
        int iIndice = partition(v, 0, v.length - 1);
        swap(v, 0, j);
        int jIndice = partition(v, 0, v.length - 1);

        int meio = v.length / 2;
        if (Math.abs(meio - iIndice) < Math.abs(meio - jIndice)) {
            return i;
        } else if (Math.abs(meio - iIndice) > Math.abs(meio - jIndice)) {
            return j;
        } else {
            return i;
        }
    }

    private static int partition(int[] v, int left, int right) {
        int i = left;
        int pivot = v[left];

        for (int j = left + 1; j <= right; j++) {
            if (v[j] < pivot) {
                swap(v, ++i, j);
            }
        }
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
}
