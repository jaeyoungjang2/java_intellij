import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2805_나무자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Integer.parseInt(st.nextToken());
        long M =  Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long left = 1;
        long right = 1;
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 0; i < N; i++) {
            long j = Integer.parseInt(st.nextToken());
            right = Math.max(right, j);
            list.add(j);
        }

        while (left < right) {
            long mid = (left + right) / 2;
            long total = 0;

            for (Long height : list) {
                long getTreeHeight = height - mid;
                if (getTreeHeight > 0) {
                    total += getTreeHeight;
                }
            }

            if (total >= M) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left - 1);
    }
}
