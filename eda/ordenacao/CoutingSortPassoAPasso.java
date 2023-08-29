package ordenacao;
import java.util.Scanner;

class CoutingSortPassoAPasso {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] entrada = converteEntrada(input.nextLine().split(" "));
        int k = input.nextInt();
        
        int[] b = coutingSort(entrada, k);

        System.out.println(printArray(b));
        input.close();
    }

    public static int[] coutingSort(int[] v, int k) {
        int[] c = new int[k + 1];
        // Iteração pra fazer a contagem (frequência) dos elementos nas respectivas posições
        for (int i = 0; i < v.length; i++) { 
            c[v[i]]++;
            System.out.println(printArray(c));
        }

        for (int i = 1; i < c.length; i++) { // Fazendo a cumulativa dos elementos
            c[i] += c[i - 1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + printArray(c));

        int[] b = new int[v.length];
        for (int i = v.length - 1; i >= 0; i--) {
            b[c[v[i]] - 1] = v[i];
            c[v[i]]--;
        }

        System.out.println(printArray(c));
        return b;
    }
     
    public static int maiorNum(int[] v) {
        int maior = v[0];
        for (int i = 1; i < v.length; i++) {
            if (v[i] > maior) {
                maior = v[i];
            }
        }
        return maior;
    }

    public static int[] converteEntrada(String[] v) {
        int[] output = new int[v.length];
        for (int i = 0; i < v.length; i++) {
          output[i] = Integer.parseInt(v[i]);
        }
        return output;
    }

    private static String printArray(int[] v) {
        String output = "";
        for (int num : v) {
            output += num + " ";
        }
        return output.trim();
    }
}
