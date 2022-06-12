import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9184_신나는함수실행 {

    private static boolean[][][] visit = new boolean[21][21][21];
    private static int[][][] record = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            int result = recursive(a, b, c);
            System.out.println(String.format("w(%s, %s, %s) = %s", a, b, c, result));
        }
    }

    private static int recursive(int a, int b, int c) {
        if (inRange(a, b, c) && visit[a][b][c]) {
            return record[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(a > 20 || b > 20 || c > 20) {
            return record[20][20][20] = recursive(20, 20, 20);
        }

        if (a < b && b < c) {
            visit[a][b][c] = true;
            return record[a][b][c] = recursive(a, b, c - 1) + recursive(a, b - 1, c - 1) - recursive(a, b - 1, c);
        }

        visit[a][b][c] = true;
        return record[a][b][c] = recursive(a - 1, b, c) + recursive(a - 1, b - 1, c) + recursive(a - 1, b, c - 1)
            - recursive(a - 1, b - 1, c - 1);
    }

    private static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
