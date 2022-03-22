package programmers;

import java.util.Arrays;
import java.util.Collections;

public class p12917 {

    public static void main(String[] args) {

        String s = "Zbcdefg";
        String answer = "";

        String upperCase = "";
        String lowerCase = "";

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upperCase += s.charAt(i);
                continue;
            }
            lowerCase += s.charAt(i);
        }


        String[] lowerSplit = lowerCase.split("");
        Arrays.sort(lowerSplit, Collections.reverseOrder());
        String lower = String.join("", lowerSplit);

        String[] upperSplit = upperCase.split("");
        Arrays.sort(upperSplit, Collections.reverseOrder());
        String upper = String.join("", upperSplit);

        answer = lower + upper;
        System.out.println(answer);
//        return answer;
    }

}
