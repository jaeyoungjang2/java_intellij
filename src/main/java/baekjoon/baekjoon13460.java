package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon13460 {
    private static boolean[][][][] visit;
    private static int[] move_row = {-1, 1, 0, 0};
    private static int[] move_col = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 보드의 세로 N
        // 보드의 가로 M
        // 가장 바깥 행은 막혀있고, 보드에는 구멍이 하나 있다.
        // 빨간 구슬과 파란구슬은 하나씩
        // 빨간 구슬을 빼내는게 목표
        // 파란 구슬을 빼면 실패
        // 동시에 빼도 실패
        // 빨간 구슬과 파란 구슬은 같은 칸에 있을 수 없다.
        // 기울이는 동작을 그만하는 것은 더이상 구슬이 움직이지 않을 때 까지
        // 최소 몇번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        Character[][] tile_info = new Character[row][col];
        Ball ball = new Ball();
        ball.setTurn(1);
        // 탈출 하는 위치
        int[] break_info = new int[2];
        for (int i = 0; i < row; i++) {
            String tiles = br.readLine();
            for (int j = 0; j < col; j++) {
                char tile = tiles.charAt(j);
                tile_info[i][j] = tile;
                if (tile == 'B') {
                    ball.setBlueRow(i);
                    ball.setBlueCol(j);
                }
                if (tile == 'R') {
                    ball.setRedRow(i);
                    ball.setRedCol(j);
                }
                if (tile == 'O') {
                    break_info[0] = i;
                    break_info[1] = j;
                }
            }
        }

        visit = new boolean[row][col][row][col];
        int endTurn = -1;
        boolean isEnd = false;

        Queue<Ball> queue = new LinkedList<>();
        queue.add(ball);

        while (!queue.isEmpty()) {
            Ball current_ball = queue.remove();
            int current_red_row = current_ball.getRedRow();
            int current_red_col = current_ball.getRedCol();
            int current_blue_row = current_ball.getBlueRow();
            int current_blue_col = current_ball.getBlueCol();
            int turn = current_ball.getTurn();

            if (turn > 10) {
                endTurn = -1;
                break;
            }

            if (isEnd) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                boolean is_red_goal = false;
                boolean is_blue_goal = false;
                int red_move_distance = 0;
                int blue_move_distnace = 0;

                int next_red_row = current_red_row + move_row[i];
                int next_red_col = current_red_col + move_col[i];
                int next_blue_row = current_blue_row + move_row[i];
                int next_blue_col = current_blue_col + move_col[i];

                while (tile_info[next_red_row][next_red_col] != '#') {
                    // 범위를 벗어나지 않았으면서
                    if (next_red_row > 0 && next_red_col > 0 && next_red_row < row
                        && next_red_col < col) {
                        // 탈출에 성공하면
                        if (tile_info[next_red_row][next_red_col] == 'O') {
                            is_red_goal = true;
                            break;
                        }

                        // 벽을 만나지 않았으면 계속해서 이동
                        next_red_row += move_row[i];
                        next_red_col += move_col[i];
                        red_move_distance ++;
                    }
                }
                // 벽을 만났으니, 이전칸으로 이동
                next_red_row -= move_row[i];
                next_red_col -= move_col[i];


                while (tile_info[next_blue_row][next_blue_col] != '#') {
                    // 범위를 벗어나지 않았으면서
                    if (next_blue_row > 0 && next_blue_col > 0 && next_blue_row < row
                        && next_blue_col < col) {
                        // 결승선에 도착하면
                        if (tile_info[next_blue_row][next_blue_col] == 'O') {
                            is_blue_goal = true;
                            break;
                        }
                        // 벽을 만나지 않았으면 계속해서 이동
                        next_blue_row += move_row[i];
                        next_blue_col += move_col[i];
                        blue_move_distnace ++;
                    }
                }
                // 벽을 만났으니 이전 상태로 이동
                next_blue_row -= move_row[i];
                next_blue_col -= move_col[i];

                // 파란공이 탈출했으면 실패
                if (is_blue_goal) {
                    continue;
                }

                // 빨간공이 탈출했으면 성공
                if (is_red_goal && !is_blue_goal) {
                    isEnd = true;
                    endTurn = turn;
                    continue;
                }

                // 빨간공과 파란공이 같은 위치에 있으면
                if (next_red_row == next_blue_row && next_red_col == next_blue_col) {
                    if (red_move_distance > blue_move_distnace) {
                        next_red_row -= move_row[i];
                        next_red_col -= move_col[i];
                    }
                    if (red_move_distance < blue_move_distnace) {
                        next_blue_row -= move_row[i];
                        next_blue_col -= move_col[i];
                    }
                }
//                System.out.printf("%s %s %s %s %s\n", turn, next_red_row, next_red_col, next_blue_row, next_blue_col);

                // 다음 이동할 위치가, 이전에 방문한 적이 없다면
                // 계속해서 문제를 풀어봅니다.
                if (!visit[next_red_row][next_red_col][next_blue_row][next_blue_col]) {
                    visit[next_red_row][next_red_col][next_blue_row][next_blue_col] = true;
                    queue.add(
                        new Ball(next_red_row, next_red_col, next_blue_row, next_blue_col, turn + 1));
                }


            }
        }
        System.out.println(endTurn);
    }


}
class Ball {
    private int redRow;
    private int redCol;
    private int blueRow;
    private int blueCol;
    private int turn;

    public Ball(int redRow, int redCol, int blueRow, int blueCol, int turn) {
        this.redRow = redRow;
        this.redCol = redCol;
        this.blueRow = blueRow;
        this.blueCol = blueCol;
        this.turn = turn;
    }

    public Ball() {
    }

    public int getRedRow() {
        return redRow;
    }

    public void setRedRow(int redRow) {
        this.redRow = redRow;
    }

    public int getRedCol() {
        return redCol;
    }

    public void setRedCol(int redCol) {
        this.redCol = redCol;
    }

    public int getBlueRow() {
        return blueRow;
    }

    public void setBlueRow(int blueRow) {
        this.blueRow = blueRow;
    }

    public int getBlueCol() {
        return blueCol;
    }

    public void setBlueCol(int blueCol) {
        this.blueCol = blueCol;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}

