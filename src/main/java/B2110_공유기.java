import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110_공유기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(houses);

        int left = 1;
        int right = houses[N - 1] - houses[0] + 1;

        int answer = 0;

        while (left <= right) {
            int findD = (left + right) / 2;

            int start = 0;
            int count = 1;

            for (int i = 1; i < N; i++) {
                if (houses[i] - houses[start] >= findD) {
                    count ++;
                    start = i;
                }
            }
            // 공유기 수가 많다면 공유기 설치된 집 간의 간격을 넓혀야 한다.
            // 공유기 수가 알맞다면, 최대 거리를 구할 때 까지 알아봐야 한다.
            if (count >= C) {
                answer = findD;
                left = findD + 1;
            // 공유기 수가 적다면 공유기 설치된 집 간의 간격을 좁혀야 한다.
            } else {
                right = findD - 1;
            }
        }
        System.out.println(answer);
    }
}
