package programmers;

import java.util.Arrays;

public class p12932 {

    public static void main(String[] args) {
        long n = 100000000000L;
        System.out.println(n);
        int[] answer = new int[(int)(Math.log10(n)+1)];
        int index = 0;
        
        while (n != 0) {
            answer[index] = (int) (n % 10);
            index ++;
            n /= 10;
        }


//        return answer;
    }
}
