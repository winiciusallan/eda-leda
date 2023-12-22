import java.util.ArrayList;
import java.util.Scanner;

class TresNMaisUm {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
       
        input.close();

        int maiorSeq = 0; 
        for (int i = n1; i <= n2; i++) {
            ArrayList<Integer> seq = new ArrayList<>();
            int N = i;

            while (N != 1) {
                if (N % 2 == 0) N = N / 2;
                else N = N * 3 + 1;
                seq.add(N);
            }

            if (seq.size() > maiorSeq) { maiorSeq = seq.size(); }
        }   

        System.out.println(++maiorSeq);
    }
}
