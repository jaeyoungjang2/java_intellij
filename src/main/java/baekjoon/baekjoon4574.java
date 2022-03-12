import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon4574 {
    private static int n;
    private static int[][] info = new int[9][9];
    private static List<Position2580> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        10
//        6 B2 1 B3
//        2 C4 9 C3
//        6 D3 8 E3
//        7 E1 4 F1
//        8 B7 4 B8
//        3 F5 2 F6
//        7 F7 6 F8
//        5 G4 9 G5
//        7 I8 8 I9
//        7 C9 2 B9
//        C5 A3 D9 I4 A9 E5 A2 C6 I1
//        0

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
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

class Position4574 {
    int row;
    int col;
    public Position4574(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
