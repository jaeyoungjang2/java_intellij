import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2579_계단오르기_bottomUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int floor = Integer.parseInt(br.readLine());

        int[] dp = new int[floor + 1];

        int[] stairs = new int[floor + 1];
        for (int i = 1; i <= floor; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        // 두 계단을 밟았을 때의 점수가 들어감
        dp[1] = stairs[1];
        if (floor >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        for (int i = 3; i <= floor; i++) {
//            dp[i] = Math.max(dp[i - 2], dp[i - 1]) + stairs[i];
            dp[i] = Math.max(dp[i - 2] , dp[i - 3] + stairs[i - 1]) + stairs[i];
        }
        System.out.println(dp[floor]);
    }
}
