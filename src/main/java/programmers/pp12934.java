package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class pp12934 {
    private static int max = 0;

    public static void main(String[] args) {
        int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int answer = 1234;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        // 모든 position에서 1로 시작하는 지를 확인
        // 1로 시작하는 곳에서 가로와 세로의 1,0 0,1 1,1    2,0 2,1 2,2 0,2, 1,2

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    go(i, j, board, 1, 1);
                }
            }
        }

//        return answer;

    }

    private static void go(int row, int col, int[][] board, int size, int target) {
        if (size > max) {
            max = size;
        }

        //10, 01, 11
        //20, 21, 22, 02, 12
        for (int i = 1; i <= target; i++) {

        }
    }
}
