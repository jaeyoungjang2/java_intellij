import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010_다리놓기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());

        for (int i = 0; i < cycle; i++) {
            System.out.println("i = " + i);
            StringTokenizer st = new StringTokenizer(br.readLine());
            long N = Integer.parseInt(st.nextToken());
            long M = Integer.parseInt(st.nextToken());
            System.out.println(factorial(M) / (factorial(M - N) * factorial(N)));
        }
    }

    private static long factorial(long n) {
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println("sum = " + sum);
        return sum;
    }
}
