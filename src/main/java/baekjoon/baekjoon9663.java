import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon9663 {
    private static int n;
    private static boolean[][] visit;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n][n];

        queen9663(0);
        System.out.println(count);
    }

    private static void queen9663(int index) {
        if (index == n) {
            count ++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (calculateQueenPosition(index, i)) {
                visit[i][index] = true;
                queen9663(index + 1);
                visit[i][index] = false;
            }
        }
    }

    private static boolean calculateQueenPosition(int col, int row) {
        int count = 1;
        while (col - count >= 0) {
            if (row + count < n && visit[row + count][col - count]) {
                return false;
            }
            if (row - count >= 0 && visit[row - count][col - count]) {
                return false;
            }
            if (visit[row][col - count]) {
                return false;
            }
            count ++;
        }
        return true;
    }
}
