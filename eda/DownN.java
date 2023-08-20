import java.util.Scanner;

class DownN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] v = converteEntrada(input.nextLine().split(" "));
        int t = input.nextInt();
        selectionSort(v, t);

        for (int i = 0; i < t; i++) {
            if (i == t - 1) {
                System.out.println(v[i]);
            } else {
                System.out.print(v[i] + " ");
            }
            
        }
        input.close();
    }

    public static void selectionSort(int[] v, int t) {

        for (int i = 0; i < t; i++) {
            int indiceDoMenor = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[indiceDoMenor]) {
                    indiceDoMenor = j;
                }
            }
            swap(v, i, indiceDoMenor);
        }
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
