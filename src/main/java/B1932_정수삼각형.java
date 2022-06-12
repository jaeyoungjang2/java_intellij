import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932_정수삼각형 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] record = new int[N + 1][N];
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count++;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < count; j++) {
                int i1 = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    record[i][j] = record[i - 1][j] + i1;
                    continue;
                }
                record[i][j] = Math.max(record[i - 1][j - 1], record[i - 1][j]) + i1;
            }
        }
        int max = 0;
        for (int i = 0; i < record[N].length; i++) {
            if (record[N][i] > max) {
                max = record[N][i];
            }
        }
        System.out.println(max);
    }
}
