import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2798_블랙잭 {
    
    private static int M;
    private static int result = 0;
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {

            list.add(Integer.parseInt(st.nextToken()));
        }


        combination(0, 0, 0);
        System.out.println(result);
    }

    private static void combination(int count, int index, int sum) {
        if (sum <= M) {
            if (count == 3) {
                result = Math.max(sum, result);
            } else {
                for (int i = index; i < list.size(); i++) {
                    combination(count + 1, i + 1, sum + list.get(i));
                }
            }
        }

    }
}
