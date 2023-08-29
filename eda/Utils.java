public class Utils {
    
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

    private static String printArray(int[] v) {
        String output = "";
        for (int num : v) {
            output += num + " ";
        }
        return output.trim();
    }

    // private static Pilha createPilha(int[] v) {
    //     Pilha output = new Pilha(v.length);
    //     for (int i = 0; i < v.length; i++) {
    //         output.push(v[i]);
    //     }
    //     return output;
    // }
}
