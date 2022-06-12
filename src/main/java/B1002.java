import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        for (int j = 0; j < i; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());



            // 두 원의 반지름의 길이
            double d = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

            // 외접원 (두 점에서 만나는 경우)
            if (Math.min(r1, r2) < d && Math.max(r1, r2) > d) {
                System.out.println(2);
                continue;
            }

            // 한 점에서 만나는 경우
            if (r1 + r2 == d || Math.abs(r1 - r2) == d) {
                System.out.println(1);
                continue;
            }

            System.out.println(0);
        }
    }
}
