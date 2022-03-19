package programmers;

import java.util.ArrayList;

public class p12954 {

    public static void main(String[] args) {
        int x = 10000000;
        int n = 200;

        long[] answer = new long[n];
        answer[0] = x;

        for (int i = 1; i < n; i++) {
            answer[i] += answer[0] * (i + 1);
        }

//        return answer;
    }
}
