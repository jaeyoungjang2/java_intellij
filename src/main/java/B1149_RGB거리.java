import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149_RGB거리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] record = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            record[i][0] = Math.min(record[i - 1][1] , record[i - 1][2]) + r;
            record[i][1] = Math.min(record[i - 1][0] , record[i - 1][2]) + g;
            record[i][2] = Math.min(record[i - 1][0] , record[i - 1][1]) + b;
        }

        System.out.println(Math.min(Math.min(record[N][0], record[N][1]), record[N][2]));
    }
}
