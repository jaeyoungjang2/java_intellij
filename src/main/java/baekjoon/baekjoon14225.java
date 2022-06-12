package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon14225 {
    private static int n;
    private static int[] info;
    private static Set<Integer> resultSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        permutation14225(0, 0);
        checkResult14225();
    }
    private static void checkResult14225() {
        List<Integer> resultList = new ArrayList<>(resultSet);
        Collections.sort(resultList);
        int threthold = 1;
        for (int number : resultList) {
            if (threthold != number) {
                System.out.println(threthold);
                return;
            }
            threthold ++;
        }
        System.out.println(threthold);
    }

    private static void permutation14225(int start, int sum) {
        if (start == n) {
            return;
        }

        for (int i = start; i < n; i++) {
            sum += info[i];
            resultSet.add(sum);
            permutation14225(i + 1, sum);
            sum -= info[i];
        }
    }
}
