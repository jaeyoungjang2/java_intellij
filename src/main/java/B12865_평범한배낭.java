import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class B12865_배낭 {

    private static int max;
    private static int answer = 0;
    private static Map<Integer, Integer> record = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 물건의 갯수
        int N = Integer.parseInt(st.nextToken());
        // 들 수 있는 무게
        max = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 100001; i++) {
            record.put(i, 0);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 적은 무게의 물건으로 최대 가치를 가질 수 있도록 해야함
            // 물건의 무게
            int W = Integer.parseInt(st.nextToken());
            // 물건의 가치
            int V = Integer.parseInt(st.nextToken());

            if (record.get(W) < W) {
                record.put(W, V);
            }
        }

        for (int i = 2; i <= max; i++) {
            
        }
    }


}
