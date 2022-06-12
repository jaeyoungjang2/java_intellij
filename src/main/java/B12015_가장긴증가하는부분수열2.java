import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        int[] info = new int[n];
        int[] index = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();

        // 가장 큰 숫자일 경우
            // 리스트 가장 뒤에 들어간다.
        // 가장 큰 숫자가 아닐 경우
            // 작은 숫자는 나보다 크거나 같은 숫자중에 가장 작은 숫자와 교체한다.

        // 10 20 10 30 20 50
        // [10 20 30 50]

        // 10 20 1 2 15 3 4
        // [ 10 ]
        // [ 10 20 ]
        // [ 1 20 ]
        // [ 1 2 ]
        // [ 1 2 15 ]
        // [ 1 2 3 ]
        // [ 1 2 3 4 ]

        int max = Integer.parseInt(st.nextToken());
        result.add(max);

        for (int i = 1; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > result.get(result.size() - 1)) {
                result.add(num);
                continue;
            }
            int left = 0;
            int right = result.size() - 1;

            while (left < right) {
                int target = (left + right) / 2;
                int compare = result.get(target);
                if (num > compare) {
                    left = target + 1;
                } else {
                    right = target;
                }
            }
            result.set(right, num);
        }
        System.out.println(result.size());
    }
}