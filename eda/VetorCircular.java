import java.util.Scanner;

class VetorCircular {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] arrInput = input.nextLine().split(" ");
        int[] arr = new int[arrInput.length];
        int n = input.nextInt();
    
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(arrInput[i]);
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i % arr.length == 0) { 
                j = 0;
            }
            
            if (i == n - 1) {
                System.out.print(arr[j] + "\n");
            } else {
                System.out.print(arr[j] + " ");
            }
            j++;
        }

        input.close();
    }    
}
