import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon16198 {
    private static int n;
    private static int[] info;
    private static boolean[] visit;
    private static List<Integer> resultList;

    public static void main(String[] args) throws IOException {
//        4
//        1 2 3 4
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        info = new int[n];
        resultList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        permutation16198(0, 0);
        Collections.sort(resultList);
        System.out.println(resultList.get(resultList.size() - 1));
    }

    private static void permutation16198(int turn, int sum) {
        if (turn == n - 2) {
            resultList.add(sum);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            if (!visit[i]) {
                visit[i] = true;
                int currentSum = calculateSum16198(i);
                permutation16198(turn + 1, sum + currentSum);
                visit[i] = false;
            }
        }
    }

    private static int calculateSum16198(int index) {
        int leftIndex = findLeft(index);
        int rightIndex = findRight(index);
        return info[leftIndex] * info[rightIndex];
    }

    private static int findRight(int index) {
        for (int i = index + 1; i < n; i++) {
            if (!visit[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("오른쪽 값이 존재하지 않습니다.");
    }

    private static int findLeft(int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (!visit[i]) {
                return i;
            }
        }
        throw new IllegalArgumentException("왼쪽 값이 존재하지 않습니다.");
    }
}
