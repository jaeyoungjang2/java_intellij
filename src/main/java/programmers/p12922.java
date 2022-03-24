package programmers;

import java.util.Collections;
import java.util.List;

public class p12922 {

    public static void main(String[] args) {
        int n = 4;

        String answer = "";
        for (int i = 0; i < n/2; i++) {
            answer += "수박";
        }
        if (n % 2 == 1) {
            answer += "수";
        }

        System.out.println(answer);
//        return answer;
    }
}
