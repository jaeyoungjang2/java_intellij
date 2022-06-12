public class iportfolio_problem3_공정리 {
    private static boolean[] visit;
    private static int[] dp;
    private static int answer;

    public static void main(String[] args) {
//        int n = 9;
//        int n = 15;
        int n = 41;


        answer = n + 1;

        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int min = i;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - (int) Math.pow(j, 2)] + 1);
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
