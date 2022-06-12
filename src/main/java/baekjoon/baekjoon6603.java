package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon6603 {
    private static int n;
    private static StringBuilder sb = new StringBuilder();
    private static int numOfLotto = 6;
    private static int[] result = new int[numOfLotto];
    private static int[] info;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            info = new int[n];

            for (int i = 0; i < n; i++) {
                info[i] = Integer.parseInt(st.nextToken());
            }
            lotto(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void lotto(int index, int start) {
        if (index == numOfLotto) {
            for (int lottoNum : result) {
                sb.append(lottoNum + " " );
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            result[index] = info[i];
            lotto(index + 1, i + 1);
        }
    }
}
