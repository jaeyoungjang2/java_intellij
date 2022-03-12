package programmers;

import java.util.HashMap;
import java.util.Map;

public class p81301 {

    public static void main(String[] args) {
//        String s = "one4seveneight";
//        String s = "23four5six7";
//        String s = "2three45sixseven";
        String s = "123";

        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        map.put("", "");

        int answer = 0;

        String result = "";
        String beforeString = "";

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(beforeString)) {
                result += map.get(beforeString);
                beforeString = "";
            }

            Character currentCharacter = s.charAt(i);
            // 현재 단어가 숫자이면 집어 넣는다.
            if (Character.isDigit(currentCharacter)) {
                result += currentCharacter;
                continue;
            }
            // 현재 단어가 숫자가 아니면 문자 저장소에 집어 넣는다.
            beforeString += currentCharacter;
        }

        if (map.containsKey(beforeString)) {
            result += map.get(beforeString);
        }

        System.out.println(result);



//        return answer;
    }
}
