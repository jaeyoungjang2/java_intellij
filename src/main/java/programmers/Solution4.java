package programmers;

import java.util.*;

class Solution4 {

    public static void main(String[] args) {
        // 시작
        int[][] board = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 3},
            {0, 2, 5, 0, 1},
            {4, 2, 4, 4, 2},
            {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        List<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new LinkedList<>());
        }

        int answer = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    list.get(j).add(board[i][j]);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            // 크레인이 인형을 뽑는 중
            // 크레인이 뽑으려는 라인이 비어있을 경우 아무 일도 일어나지 않는다.
            if (list.get(moves[i] - 1).isEmpty()) {
                continue;
            }

            // 인형을 뽑고
            Integer doll = list.get(moves[i] - 1).remove();
            // 이전 인형이 있으면
            if (!stack.isEmpty()) {
                // 이전 인형과 비교 합니다.
                Integer beforeDoll = stack.peek();
                if (doll == beforeDoll) {
                    // 같은 인형이 있으면 폭파 시키고, 다음 인형을 뽑으러 갑시다
                    stack.pop();
                    answer += 2;
                    continue;
                }
                // 같은 인형이 없다면 넣어줍시다.
                stack.add(doll);
                continue;
            }
            // 이전 인형이 없다면 인형을 넣어줍시다
            stack.add(doll);
        }

        System.out.println(answer);

//        return answer;

    }
}