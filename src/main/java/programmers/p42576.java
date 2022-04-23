package programmers;

import java.util.HashMap;
import java.util.Map;

public class p42576 {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = "";

        Map<String, Integer> map = new HashMap<>();

        for (String human: participant) {
            map.put(human, map.getOrDefault(human, 0) + 1);
        }

        for (String human: completion) {
            map.put(human, map.get(human) - 1);
        }

        for (String human: map.keySet()) {
            if (map.get(human) != 0) {
                answer = human;
            }
        }
//        return answer;
    }
}
