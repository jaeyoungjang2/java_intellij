import java.util.HashMap;
import java.util.Map;

public class p7232 {

    public static void main(String[] args) {
        String s = "[";

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Character> transfer = new HashMap<>();
        transfer.put(']', '[');
        transfer.put(')', '(');
        transfer.put('}', '{');

        int answer = 0;
        int cycle = s.length();
        for (int i = 0; i < cycle; i++) {
            initMap(map);
            if (isTrue(s, map, transfer)) {
                answer ++;
            }
            String frontS = s.substring(0, 1);
            String backS = s.substring(1, cycle);
            s = backS + frontS;
            System.out.printf(s + "\n");
        }
        System.out.println(answer);
    }

    private static boolean isTrue(String s, Map<Character, Integer> map, Map<Character, Character> transfer) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '(' || c == '{') {
                map.put(c, map.get(c) + 1);
                continue;
            }
            if (c == ']' || c == ')' || c == '}') {
                char tc = transfer.get(c);
                map.put(tc, map.get(tc) - 1);
                if (map.get(tc) < 0) {
                    return false;
                }
            }
        }

        for (Character character : map.keySet()) {
            if (map.get(character) != 0) {
                return false;
            }
        }
        return true;

    }

    private static void initMap(Map<Character, Integer> map) {
        map.put('(', 0);
        map.put('[', 0);
        map.put('{', 0);
    }
}
