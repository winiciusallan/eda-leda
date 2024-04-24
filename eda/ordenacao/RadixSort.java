import java.util.Arrays;

public class RadixSort {

    public static void radixSort(int[] v) {
        int max = getMax(v);

        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(v, i);
        }
    }

    public static void countingSort(int[] v, int expoente) {
        int[] A = new int[v.length];
        int[] C = new int[10];
        Arrays.fill(C, 0);

        for (int i = 0; i < v.length; i++) {
            C[(v[i] / expoente) % 10] += 1;
        }

        for (int i = 1; i < C.length; i++) {
            C[i] += C[i - 1];
        }

        for (int i = v.length - 1; i >= 0; i--) {
            A[C[(v[i] / expoente) % 10] - 1] = v[i];
            C[(v[i] / expoente) % 10]--;
        }

        for (int i = 0; i < v.length; i++) {
            v[i] = A[i];
        }

    }

    private static int getMax(int[] v) {
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < v.length; i++) {
            if (v[i] > max) {
                max = v[i];
            }
        }

        return max;
    }
}
