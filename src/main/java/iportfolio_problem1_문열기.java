public class iportfolio_problem1_문열기 {

    public static void main(String[] args) {
        // db indexing을 하는 이유

        int n = 100000000;
        // 문이 열린 상태 == false
        // 1, 2, 2, 3, 2, 4, 2, 4, 3, 4
        // 1 [1]
        // 2 [1, 2]
        // 3 [1, 3]
        // 4 [1, 2, 4]
        // 5 [1, 5]
        // 6 [1, 2, 3, 6]
        // 7 [1, 7]
        // 8 [1, 2, 4, 8]
        // 9 [1, 3, 9]
        // 10 [1, 2, 5, 10]
        int answer = 0;


        for (int i = 1; i <= n; i++) {
            // 약수의 개수 구하기
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    count++;
                } else if (i % j == 0) {
                    count += 2;
                }
            }
            if (count % 2 == 1) {
                answer ++;
            }
        }

        System.out.println(answer);


//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; i * j <= n; j++) {
//                // 열린 상태면 닫고
//                // 닫힌 상태면 열고
//                if (!doorStatus[i * j]) {
//                    doorStatus[i * j] = true;
//                } else {
//                    doorStatus[i * j] = false;
//                }
//            }
//        }
//        int answer = 0;
//        for (int i = 1; i <= n; i++) {
//            if (!doorStatus[i]) {
//                System.out.println("i = " + i);
//                answer ++;
//            }
//        }
//
//
//        System.out.println(answer);
    }
}
