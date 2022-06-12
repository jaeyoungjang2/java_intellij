package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon2580 {
    private static int[][] info = new int[9][9];
    private static List<Position2580> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        0 3 5 4 6 9 2 7 8
//        7 8 2 1 0 5 6 0 9
//        0 6 0 2 7 8 1 3 5
//        3 2 1 0 4 6 8 9 7
//        8 0 4 9 1 3 5 0 6
//        5 9 6 8 2 0 4 1 3
//        9 1 7 6 5 2 0 8 0
//        6 0 3 7 0 1 9 5 2
//        2 5 8 3 9 4 7 6 0
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int number = Integer.parseInt(st.nextToken());
                info[i][j] = number;
                if (number == 0) {
                    list.add(new Position2580(i, j));
                }
            }
        }
        dfs2580(0);

    }

    private static void dfs2580(int index) {
        if (index == list.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(info[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        Position2580 position2580 = list.get(index);
        int row = position2580.row;
        int col = position2580.col;

        for (int i = 1; i < 10; i++) {
            if (check(row, col, i)) {
                info[row][col] = i;
                dfs2580(index + 1);
                info[row][col] = 0;
            }
        }
    }

    private static boolean check(int row, int col, int value) {
        if (checkRow(row, value) && checkCol(col, value) && checkSquare(row, col, value)) {
            return true;
        }
        return false;
    }

    private static boolean checkSquare(int row, int col, int value) {
        // 0 - 2, 3 - 5, 6 - 9
        int rowRange = (row / 3) * 3;
        int colRange = (col / 3) * 3;
        for (int i = rowRange; i < rowRange + 3; i++) {
            for (int j = colRange; j < colRange + 3; j++) {
                if (info[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkCol(int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (info[i][col] == value) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int row, int value) {
        for (int i = 0; i < 9; i++) {
            if (info[row][i] == value) {
                return false;
            }
        }
        return true;
    }
}

class Position2580 {
    int row;
    int col;
    public Position2580(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
