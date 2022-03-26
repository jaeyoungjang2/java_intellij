package programmers;

import java.util.Arrays;

public class p12982 {

    public static void main(String[] args) {

//        int[] d = {1, 3, 2, 5, 4};
//        int budget = 9;
        int[] d = {2,2,3,3};
        int budget = 10;

        // 시작
        int answer = 0;
        Arrays.sort(d);
        int totalAmount = 0;
        for (int i = 0; i < d.length; i++) {
            totalAmount += d[i];
            if (totalAmount <= budget) {
                answer ++;
                continue;
            }
            break;
        }

        System.out.println("totalAmount = " + answer);
        // return answer;
    }
}
