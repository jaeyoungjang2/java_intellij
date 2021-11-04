import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1182 {
    private static int n;
    private static int s;
    private static int[] info;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        info = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += info[i];
            permutation1182(i + 1, sum);
            sum -= info[i];
        }
        System.out.println(count);
    }
    private static void permutation1182(int start, int sum) {
        if (start == n + 1) {
            return;
        }

        if (sum == s) {
            count ++;
        }

        for (int i = start; i < n; i++) {
            sum += info[i];
            permutation1182(i + 1, sum);
            sum -= info[i];
        }
    }
}
