import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1934_최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cycle; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int gcd = GCD(i1, i2);
            int lcm = gcd * (i1 / gcd) * (i2 / gcd);
            sb.append(lcm + "\n");
        }
        System.out.println(sb.toString());
    }

    private static int GCD(int i1, int i2) {
        if (i1 % i2 == 0) {
            return i2;
        }
        return GCD(i2, i1 % i2);
    }
}
