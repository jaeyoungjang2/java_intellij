package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class b17837 {
    // 우, 좌, 상, 하
    private static int[] add_next_row = {0, 0, -1, 1};
    private static int[] add_next_col = {1, -1, 0, 0};
    private static int[] convert_arrow = {1, 0, 3, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 체스판의 크기
        int n = Integer.parseInt(st.nextToken());
        // 말의 개수
        int k = Integer.parseInt(st.nextToken());

        int[][] tile_info = new int[n][n];
        List<Integer>[][] horse_current_position = new ArrayList[n][n];
        List<Horse> horses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tile_info[i][j] = Integer.parseInt(st.nextToken());
                horse_current_position[i][j] = new ArrayList<>();
            }
        }


        for (int i = 0; i <k; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int arrow = Integer.parseInt(st.nextToken()) - 1;
            Horse horse = new Horse(row, col, arrow);
            horses.add(horse);
            horse_current_position[row][col].add(i);
        }

        int turn = 0;
        boolean isEnd = false;

        while (turn < 1000) {
            if (isEnd) {
                break;
            }
            // 말의 순서대로 확인
            for (int i = 0; i < k; i++) {
                Horse horse = horses.get(i);
                int current_row = horse.getRow();
                int current_col = horse.getCol();
                int current_arrow = horse.getArrow();
                int next_row = current_row + add_next_row[current_arrow];
                int next_col = current_col + add_next_col[current_arrow];
                if (next_row < 0 || next_col < 0 || next_row >= n || next_col >= n
                    || tile_info[next_row][next_col] == 2) {
                    // 방향 전환
                    current_arrow = convert_arrow[current_arrow];
                    horse.setArrow(current_arrow);

                    next_row = current_row + add_next_row[current_arrow];
                    next_col = current_col + add_next_col[current_arrow];

                    if (next_row < 0 || next_col < 0 || next_row >= n || next_col >= n
                        || tile_info[next_row][next_col] == 2) {
                        continue;
                    }
                }

                // 스택 정리
                List<Integer> current_tile_horses = horse_current_position[current_row][current_col];
                List<Integer> moving_horses = new ArrayList<>();
                for (int j = 0; j < current_tile_horses.size(); j++) {
                    if (i == current_tile_horses.get(j)) {
                        moving_horses = current_tile_horses
                            .subList(j, current_tile_horses.size());
                        // 현재위치에서 제거

                        horse_current_position[current_row][current_col] = new ArrayList<>(current_tile_horses
                            .subList(0, j));
                        break;
                    }
                }

                // 빨간 타일이면
                if (tile_info[next_row][next_col] == 1) {
                    Collections.reverse(moving_horses);
                }

                // 위치를 옮기는 말들 위치 변경

                for (Integer moving_horse_index : moving_horses) {
                    horses.get(moving_horse_index).setRow(next_row);
                    horses.get(moving_horse_index).setCol(next_col);
                    horse_current_position[next_row][next_col].add(moving_horse_index);
                }

                if (horse_current_position[next_row][next_col].size() >= 4) {
                    isEnd = true;
                }
            }

            turn ++;
        }

        if (turn == 1000) {
            System.out.println(-1);
        } else {
            System.out.println(turn);
        }

    }

    static class Horse {
        private int row = 0;
        private int col = 0;
        private int arrow = 0;

        public Horse(int row, int col, int arrow) {
            this.row = row;
            this.col = col;
            this.arrow = arrow;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }

        public int getArrow() {
            return arrow;
        }

        public void setArrow(int arrow) {
            this.arrow = arrow;
        }
    }
}
