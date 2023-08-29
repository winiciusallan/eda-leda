package ordenacao;
import java.util.Arrays;
import java.util.Scanner;

class SelectionSortPassoAPasso {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] entradaTemp = input.nextLine().split(" ");
        int[] entrada = converteEntrada(entradaTemp);
        
        selectionSort(entrada);
        
        input.close();
    }

    public static void selectionSort(int[] v) {
        for (int j = 0; j < v.length - 1; j++) {
            boolean ordenado = true;

            // Encontramos os n menores números para fazer o swap
            int indiceDoMenor = j;
            for (int i = j + 1; i < v.length; i++) { // A iteração começa de 1 já que assumimos o primeiro como menor
                if (v[i] < v[indiceDoMenor]) {
                    ordenado = false;
                    indiceDoMenor = i;
                }
            }
            swap(v, indiceDoMenor, j);
            if (!ordenado) {
                System.out.println(Arrays.toString(v));
            }
        }
    }

    public static boolean isSorted(int[] v) {
        boolean sorted = true;
        for (int i = 0; i < v.length - 1; i++) {
            if (!(v[i] < v[i + 1])) {
                sorted = false;
               }
        }
        return sorted;
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
