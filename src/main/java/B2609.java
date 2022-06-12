import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int gcd = GCD(n1, n2);
        int lcm = (n1 / gcd) * (n2 / gcd) * gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }

    private static int GCD(int n1, int n2) {
        if (n1 % n2 == 0) {
            return n2;
        }
        n1 %= n2;
        return GCD(n2, n1);
    }
}
