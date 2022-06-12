import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2110_공유기설치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        int left = list.get(0);
        int right = list.get(list.size() - 1);

        while (left < right) {
            int mid = (left + right) / 2;

            // 공유기의 개수
            int count = 1;
            // 이전 집
            int beforeHouse = list.get(0);

            for (int i = 1; i < list.size(); i++) {
                int distance = list.get(i) - beforeHouse;
                if (distance >= mid) {
                    count ++;
                    beforeHouse = list.get(i);
                }
            }

            // 공유기 간 이격 거리를 mid라고 했을 때
            // 설치할 수 있는 공유기의 수가 지정한 공유기의 수 보다 많다면
            // 공유기간의 이격 거리를 늘린다.

            // 같다면
            // 이격 거리를 늘리고,

            if (count >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(right);
    }
}
