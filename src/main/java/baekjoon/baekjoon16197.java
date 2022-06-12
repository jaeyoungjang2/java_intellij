package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16197 {
    private static int[] rowTemp = {-1, 1, 0, 0};
    private static int[] colTemp = {0, 0, -1 ,1};
    private static boolean[][][][] visit;
    private static int n;
    private static int m;
    private static Character[][] info;
    private static int maxTurn = 10;

    public static void main(String[] args) throws IOException {
//        1 2
//        oo
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        info = new Character[n][m];
        visit = new boolean[n][m][n][m];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                Character coinSymbol = temp.charAt(j);
                info[i][j] = coinSymbol;
                if (coinSymbol == 'o') {
                    list.add(i);
                    list.add(j);
                }
            }
        }

        Queue<CoinsPosition> queue = new LinkedList<>();
        visit[list.get(0)][list.get(1)][list.get(2)][list.get(3)] = true;
        queue.add(new CoinsPosition(list.get(0), list.get(1), list.get(2), list.get(3), 0));

        bfs16197(queue);
        System.out.println(-1);
    }

    private static void bfs16197(Queue<CoinsPosition> queue) {
        while (!queue.isEmpty()) {
            CoinsPosition coinsPosition = queue.remove();
            int coin1row = coinsPosition.coin1row;
            int coin1col = coinsPosition.coin1col;
            int coin2row = coinsPosition.coin2row;
            int coin2col = coinsPosition.coin2col;
            int turn = coinsPosition.turn;

            if (turn == maxTurn) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextCoin1row = coin1row + rowTemp[i];
                int nextCoin1col = coin1col + colTemp[i];
                int nextCoin2row = coin2row + rowTemp[i];
                int nextCoin2col = coin2col + colTemp[i];
                int nextTurn = turn + 1;

                int fallenNum = 0;
                if (nextCoin1row < 0 || nextCoin1row >= n || nextCoin1col < 0 || nextCoin1col >= m ) {
                    fallenNum ++;
                }
                if (nextCoin2row < 0 || nextCoin2row >= n || nextCoin2col < 0 || nextCoin2col >= m ) {
                    fallenNum ++;
                }

                if (fallenNum == 2) {
                    continue;
                } else if (fallenNum == 1) {
                    System.out.println(nextTurn);
                    System.exit(0);
                }


                if (info[nextCoin1row][nextCoin1col] == '#') {
                    nextCoin1row = coin1row;
                    nextCoin1col = coin1col;
                }
                if (info[nextCoin2row][nextCoin2col] == '#') {
                    nextCoin2row = coin2row;
                    nextCoin2col = coin2col;
                }

                if (!visit[nextCoin1row][nextCoin1col][nextCoin2row][nextCoin2col]) {
                    visit[nextCoin1row][nextCoin1col][nextCoin2row][nextCoin2col] = true;

//                    System.out.println(fallenNum);
//                    System.out.println(nextCoin1row);
//                    System.out.println(nextCoin1col);
//                    System.out.println(nextCoin2row);
//                    System.out.println(nextCoin2col);
//                    System.out.println();
                    queue.add(new CoinsPosition(nextCoin1row, nextCoin1col, nextCoin2row, nextCoin2col, nextTurn));
                }
            }
        }

    }
}

class CoinsPosition {
    int turn;
    int coin1row;
    int coin1col;
    int coin2row;
    int coin2col;

    public CoinsPosition(int coin1row, int coin1col, int coin2row, int coin2col, int turn) {
        this.coin1row = coin1row;
        this.coin1col = coin1col;
        this.coin2row = coin2row;
        this.coin2col = coin2col;
        this.turn = turn;
    }
}
