import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 물건의 갯수
        int N = Integer.parseInt(st.nextToken());
        // 들 수 있는 무게
        int max = Integer.parseInt(st.nextToken());

        ArrayList<Integer> weights = new ArrayList<>();
        ArrayList<Integer> values = new ArrayList<>();
        weights.add(0);
        values.add(0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights.add(Integer.parseInt(st.nextToken()));
            values.add(Integer.parseInt(st.nextToken()));
        }

        int[][] record = new int[max + 1][N + 1];
        // 들 수 있는 최대 무게
        for (int i = 1; i <= max; i++) {
            // 물건 종류별로 확인
            for (int j = 1; j <= N; j++) {
                // 현재 물건의 무게와 가치
                Integer weight = weights.get(j);
                Integer value = values.get(j);

                if (weight > i) {
                    record[i][j] = Math.max(record[i - 1][j], record[i][j - 1]);
                    continue;
                }
                record[i][j] = Math.max(record[i - 1][j], record[i][j - 1]);
                record[i][j] = Math.max(record[i][j], record[i - weight][j - 1] + value);
            }
        }
        System.out.println(record[max][N]);
    }
}
