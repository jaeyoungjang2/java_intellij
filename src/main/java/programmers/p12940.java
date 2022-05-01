package programmers;

public class p12940 {

    public static void main(String[] args) {
//        int n = 3;
//        int m = 12;
        int n = 2;
        int m = 5;

        // 시작

        int gcdNum = gcd(n, m);
        int lcmNum = n * m / gcdNum;
        System.out.println("gcdNum = " + gcdNum);
        System.out.println("lcmNum = " + lcmNum);

        int[] answer = {gcdNum, lcmNum};
//        return answer;
    }

    private static int gcd(int n, int m) {
        if (m == 0) {
            return n;
        }
        return gcd(m, n % m);
    }
}

