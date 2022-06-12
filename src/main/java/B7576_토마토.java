import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B7576_토마토 {
    private static int[] addRow = {-1, 1, 0, 0};
    private static int[] addCol = {0, 0, -1, 1};
    private static int N;
    private static int M;
    private static boolean[][] visit;
    private static int[][] tomatoStates;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tomatoStates = new int[M][N];
        visit = new boolean[M][N];
        List<TomatoPosition> checkLists = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int tomatoState = Integer.parseInt(st.nextToken());
                tomatoStates[i][j] = tomatoState;

                if (tomatoState == 1) {
                    checkLists.add(new TomatoPosition(i, j, 0));
                }
            }
        }

        Queue<TomatoPosition> tomatoPositions = new LinkedList<>();
        for (TomatoPosition tomatoPosition : checkLists) {
            int tomatoRow = tomatoPosition.getRow();
            int tomatoCol = tomatoPosition.getCol();
            if (!visit[tomatoRow][tomatoCol]) {
                visit[tomatoRow][tomatoCol] = true;
                tomatoPositions.add(new TomatoPosition(tomatoRow, tomatoCol, 0));
            }
        }
        bfs(tomatoPositions);

        checkResult();
    }

    private static void checkResult() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (tomatoStates[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(max);
    }

    private static void bfs(Queue<TomatoPosition> tomatoPositions) {

        while (!tomatoPositions.isEmpty()) {
            TomatoPosition currentPosition = tomatoPositions.remove();
            int row = currentPosition.getRow();
            int col = currentPosition.getCol();
            int day = currentPosition.getDay();

            if (day > max) {
                max = day;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = row + addRow[i];
                int nextCol = col + addCol[i];
                int nextDay = day + 1;

                if (nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N) {
                    if (!visit[nextRow][nextCol]) {
                        visit[nextRow][nextCol] = true;
                        if (tomatoStates[nextRow][nextCol] != -1) {
                            tomatoPositions.add(new TomatoPosition(nextRow, nextCol, nextDay));
                            tomatoStates[nextRow][nextCol] = 1;
                        }
                    }
                }
            }
        }
    }

    private static class TomatoPosition {
        private int row;
        private int col;
        private int day;

        public TomatoPosition(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }

        public int getDay() {
            return day;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
