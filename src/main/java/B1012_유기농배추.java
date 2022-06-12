import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1012_유기농배추 {

    private static int[] rowTemp = {-1, 1, 0, 0};
    private static int[] colTemp = {0, 0, -1, 1};
    private static boolean[][] visit;
    private static int[][] cabbageStates;
    private static int row;
    private static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cycle = Integer.parseInt(st.nextToken());

        for (int i = 0; i < cycle; i++) {
            st = new StringTokenizer(br.readLine());
            col = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            cabbageStates = new int[row][col];
            visit = new boolean[row][col];

            // 양배추 심은 곳 표기
            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int cabbageCol = Integer.parseInt(st.nextToken());
                int cabbageRow = Integer.parseInt(st.nextToken());
                cabbageStates[cabbageRow][cabbageCol] = 1;
            }

            int count = 0;
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < col; k++) {
                    if (!visit[j][k] && cabbageStates[j][k] == 1) {
                        visit[j][k] = true;
                        count ++;
                        dfs(new CabbagePosition(j, k));
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(CabbagePosition cab) {
        Queue<CabbagePosition> queue = new LinkedList<>();
        queue.add(cab);

        while (!queue.isEmpty()) {
            CabbagePosition cabbagePosition = queue.remove();
            int currentRow = cabbagePosition.getRow();
            int currentCol = cabbagePosition.getCol();

            for (int i = 0; i < 4; i++) {

                int nextRow = currentRow + rowTemp[i];
//                System.out.println("nextRow = " + nextRow);
                int nextCol = currentCol + colTemp[i];

                if (nextCol >= 0 && nextCol < col && nextRow >= 0 && nextRow < row) {
                    if (!visit[nextRow][nextCol] && cabbageStates[nextRow][nextCol] == 1) {
                        visit[nextRow][nextCol] = true;
                        queue.add(new CabbagePosition(nextRow, nextCol));
                    }
                }
            }
        }
    }

    private static class CabbagePosition{
        private int row;
        private int col;

        public CabbagePosition(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
