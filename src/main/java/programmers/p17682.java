package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p17682 {

    public static void main(String[] args) {
//        String dartResult = "1S2D*3T";
//        String dartResult = "1D2S#10S";
//        String dartResult = "1D2S0T";
//        String dartResult = "1S*2T*3S";
//        String dartResult = "1D#2S*3S";
//        String dartResult = "1T2D3D#";
        String dartResult = "1D2S3T*";

        // 시작
        int answer = 0;
        List<Character> bonustList = new ArrayList<>(Arrays.asList('S', 'D', 'T'));
        List<Character> optionlist = new ArrayList<>(Arrays.asList('*', '#'));
        List<Integer> result = new ArrayList<>();
        int index = -1;
        String integerTemp = "";
        for (int i = 0; i < dartResult.length(); i++) {
            char dart = dartResult.charAt(i);

            if (bonustList.contains(dart)) {
                result.add(Integer.parseInt(integerTemp));
                index++;
                integerTemp = "";

                if (dart == 'S') {
                    continue;
                }
                if (dart == 'D') {
                    result.set(index, (int) Math.pow(result.get(index), 2));
                    continue;
                }
                if (dart == 'T') {
                    result.set(index, (int) Math.pow(result.get(index), 3));
                    continue;
                }

            }
            if (optionlist.contains(dart)) {
                if (dart == '*') {
                    if (index == 0) {
                        result.set(index, result.get(index) * 2);
                        continue;
                    }
                    result.set(index, result.get(index) * 2);
                    result.set(index - 1, result.get(index - 1) * 2);
                    continue;
                }
                if (dart == '#') {
                    result.set(index, - result.get(index));
                    continue;
                }
            }
            integerTemp += dart;
        }

        for (int i = 0; i < result.size(); i++) {
            answer += result.get(i);
        }
        System.out.println(answer);

        // return answer;
    }
}
