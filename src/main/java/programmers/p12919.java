package programmers;

import java.util.Arrays;
import java.util.List;

public class p12919 {

    public static void main(String[] args) {
        String[] seoul = {"Jane", "Kim"};

        String answer = "";

        List<String> list = Arrays.asList(seoul);
        int kimIndex = list.indexOf("Kim");

        answer = String.format("김서방은 %s에 있다", kimIndex);
//        return answer;

    }
}
