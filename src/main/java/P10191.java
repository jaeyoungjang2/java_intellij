import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P10191 {
    // 행열 크기
    private static int n;
    private static boolean[] visit;
    private static List<List<Integer>> list = new ArrayList<>();

    public static void main(String[] args) {
//        int[][] dist = {{0, 5, 2, 4, 1}, {5, 0, 3, 9, 6}, {2, 3, 0, 6, 3}, {4, 9, 6, 0, 3},
//            {1, 6, 3, 3, 0}};

        int[][] dist = {{0, 2, 3, 1}, {2, 0, 1, 1}, {3, 1, 0, 2}, {1, 1, 2, 0}};


        n = dist.length;
        visit = new boolean[n];

        Stack stack = new Stack();
        permutation(stack, dist);
        int[][] answer = new int[list.size()][n];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = list.get(i).get(j);
            }
        }




//        return answer;

    }

    private static void permutation(Stack<Integer> stack, int[][] dist) {
        if (stack.size() == n) {

            for (int j = 1; j <n ; j++) {
                if (dist[stack.get(0)][stack.get(j)] != dist[stack.get(0)][stack.get(j - 1)] + dist[stack.get(j - 1)][stack.get(j)]) {
                    return;
                }
            }
            list.add(new ArrayList<>());
            for (int i = 0; i < stack.size(); i++) {
                list.get(list.size()-1).add(stack.get(i));
            }
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < n; i++) {

            if (!visit[i]) {
                stack.add(i);
                if (stack.size() > 3) {
                    int first = stack.get(0);
                    int last_before = stack.get(stack.size() - 2);
                    int last = stack.get(stack.size() - 1);

                    if (dist[first][last] != dist[first][last_before] + dist[last_before][last]) {
                        stack.pop();
                        continue;
                    }
                }
                visit[i] = true;
                permutation(stack, dist);
                visit[i] = false;
                stack.pop();
            }
        }
    }
}
