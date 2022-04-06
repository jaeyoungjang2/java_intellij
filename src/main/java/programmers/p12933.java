package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class p12933 {

    public static void main(String[] args) {
        long n = 118372;
        long answer = 0;

        String s = String.valueOf(n);
        String[] split = s.split("");
        System.out.println("s = " + s);
        
        Arrays.sort(split, Collections.reverseOrder());

        String temp = "";
        for (int i = 0; i < split.length; i++) {
            temp += split[i];
        }

        answer = Long.parseLong(temp);
//        return answer;


        
        
    }
}
