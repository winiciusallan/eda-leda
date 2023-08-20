import java.util.Scanner;

class EstatisticaDeOrdem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] v = converteEntrada(input.nextLine().split(" "));


        System.out.println(partition(v, 0, v.length - 1));
    }   

    private static int partition(int[] v, int left, int right) {
        int i = left;
        int pivot = v[left];

        for (int j = left + 1; j <= right; j++) {
            if (v[j] < pivot) {
                swap(v, ++i, j);
            }
        }
        swap(v, left, i);
        return i + 1;
    }

    private static void swap(int[] v, int i, int j) {
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
