package programmers;

import java.util.Arrays;

public class pp12931 {

    public static void main(String[] args) {
        int n = 123;
        int answer = 0;
        while (n != 0) {
            int r = n % 10;
            n = n / 10;
            answer += r;
        }
        System.out.println(answer);
    }
}
