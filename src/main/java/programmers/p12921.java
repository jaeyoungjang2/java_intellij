package programmers;

public class p12921 {

    public static void main(String[] args) {
        int n = 5;

        // 시작
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isDecimal(i)) {
                answer ++;
            }
        }

//        return answer;
    }

    private static boolean isDecimal(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
