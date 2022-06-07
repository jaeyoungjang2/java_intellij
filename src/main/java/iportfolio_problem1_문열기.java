public class P323_문열기 {

    public static void main(String[] args) {
        int n = 2;
        // 문이 열린 상태 == false
        boolean[] doorStatus = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; i * j <= n; j++) {
                // 열린 상태면 닫고
                // 닫힌 상태면 열고
                if (!doorStatus[i * j]) {
                    doorStatus[i * j] = true;
                } else {
                    doorStatus[i * j] = false;
                }
            }
        }
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!doorStatus[i]) {
                System.out.println("i = " + i);
                answer ++;
            }
        }


        System.out.println(answer);
    }
}
