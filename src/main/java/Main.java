import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] info = new int[n];
        int[] index = new int[n];
        int res = 1;

        for (int i = 0; i < n; i++) {
            info[i] = sc.nextInt();
            int maxIndex = 1;
            for (int j = 0; j < i; j++) {
                if (info[i] > info[j] && maxIndex <= index[j]) {
                    maxIndex = index[j] + 1;
                    res = Math.max(res, maxIndex);
                }
            }
            index[i] = maxIndex;
        }
        
        System.out.println(res);
    }
}