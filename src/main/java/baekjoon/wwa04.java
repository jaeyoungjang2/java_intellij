package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wwa04 {

    public static void main(String[] args) {
//        String s = "aaabbaaa";
//        String s = "wowwow";
//        String s = "aaa";
//        String s = "bbbabbb";
//        String s = "cccaabbc";
//        String s = "abcabcabca";
        String s = "wowwowwowwow";


        Set<Character> duplicateCheck = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            duplicateCheck.add(s.charAt(i));
        }

        int index = 0;
        List<Integer> resultList = new ArrayList<>();

        if (duplicateCheck.size() >= 2) {
            Character initCharacter = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                Character currentCaracter = s.charAt(i);
                if (initCharacter != currentCaracter) {
                    s = s.substring(i, s.length()) + s.substring(0, i);
                    break;
                }
            }

            initCharacter = s.charAt(0);
            int duplicate = 1;
            for (int i = 1; i < s.length(); i++) {
                Character currentCaracter = s.charAt(i);
                if (initCharacter != currentCaracter) {
                    resultList.add(duplicate);
                    index++;
                    duplicate = 1;
                    initCharacter = currentCaracter;
                    continue;
                }
                duplicate ++;
            }
            resultList.add(duplicate);
        }
        Collections.sort(resultList);

        if (duplicateCheck.size() < 2) {
            int[] answer = {s.length()};
            System.out.println(Arrays.toString(answer));
        } else {
            int[] answer = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                answer[i] = resultList.get(i);
            }
            System.out.println(Arrays.toString(answer));
        }
    }
}
