package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon2580_2 {

    private static int[][] info = new int[9][9];
    private static List<Position2580_2> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                int number = Integer.parseInt(st.nextToken());
                info[i][j] = number;
                if (number == 0) {
                    // 빈칸의 위치 저장
                    list.add(new Position2580_2(i, j));
                }
            }
        }

        // 빈칸의 위치를 리스트로 부터 한칸씩 꺼낸 뒤에
        // 1 ~ 9 사이의 숫자를 넣어본다.
        // 백트래킹을 이용해서 구현
         backtraking(0);
    }

    private static void backtraking(int index) {
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
        Position2580_2 blank = list.get(index);
        int row = blank.row;
        int col = blank.col;

        for (int i = 1; i <= 9; i++) {
            if (checkRow(row, i) && checkCol(col, i) && checkArea(row, col, i)) {
                info[row][col] = i;
                backtraking(index + 1);
                info[row][col] = 0;
            }
        }
        return;
    }

    private static boolean checkArea(int row, int col, int value) {
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

    private static boolean checkCol(int col, int i) {
        for (int j = 0; j < 9; j++) {
            if (info[j][col] == i) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int row, int i) {
        for (int j = 0; j < 9; j++) {
            if (info[row][j] == i) {
                return false;
            }
        }
        return true;
    }
}

class Position2580_2 {
    int row;
    int col;

    public Position2580_2(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
