import java.util.Scanner;

class SomaFolhas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Bst tree = new Bst();
        int[] entrada = converteEntrada(input.nextLine().split(" "));

        for (int elem : entrada) {
            tree.recursiveAdd(elem);
        }

        System.out.println(tree.somaFolha());

        input.close();
    }   
    
    public static int[] converteEntrada(String[] v) {
        int[] output = new int[v.length];
        for (int i = 0; i < v.length; i++) {
          output[i] = Integer.parseInt(v[i]);
        }
        return output;
    }
}
