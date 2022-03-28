import java.util.ArrayList;

public class Solution3 {

    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}};
//        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int[] moves = {1, 1, 1, 1};
        int answer = 0;
        ArrayList<Integer> bucket = new ArrayList<>();

        // 한번씩 이동
        for (int i : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i - 1] != 0) {
                    System.out.println(board[j][i - 1]);
                    bucket.add(board[j][i - 1]);
                    board[j][i - 1] = 0;
                    break;
                }
            }

            if (bucket.size() >= 2 && (bucket.get(bucket.size() - 1)
                .equals(bucket.get(bucket.size() - 2)))) {
                bucket.remove(bucket.size() - 1);
                bucket.remove(bucket.size() - 1);
                answer += 2;
            }
        }
        // System.out.println(bucket);
         System.out.println(answer);
//        return answer;
    }
}