import java.util.Arrays;
import java.util.Scanner;

class Warmup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        input.nextLine();
        String[] temp = input.nextLine().split(" ");
        int[] nums = new int[temp.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        multiplicaPorN(n, nums);
        input.close();

        String output = "";
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                output += nums[i];
            } else {
                output += nums[i] + " ";
            }
        }
        
        System.out.println(output);
    }

    public static void multiplicaPorN(int n, int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] *= n;
        }
    }
}
