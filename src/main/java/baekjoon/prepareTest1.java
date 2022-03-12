import java.util.*;

public class prepareTest1 {

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            String human = participant[i];
            map.put(human, 0);
        }

        for (int i = 0; i < participant.length; i++) {
            String human = participant[i];
            map.put(human, map.get(human) + 1);
        }

        for (int i = 0; i < completion.length; i++) {
            String human = completion[i];
            map.put(human, map.get(human) - 1);
        }

        for (int i = 0; i < completion.length; i++) {
            String human = participant[i];
            if (map.get(human) != 0) {
                answer = human;
            }
        }
    }
}
