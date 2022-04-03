import java.util.HashMap;
import java.util.Map;

public class p42860 {
    private static Map<Character, Integer> map = new HashMap();
    
    public static void main(String[] args) {
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        map.put('I', 8);
        map.put('J', 9);
        map.put('K', 10);
        map.put('L', 11);
        map.put('M', 12);
        map.put('N', 13);
        map.put('O', 14);
        map.put('P', 15);
        map.put('Q', 16);
        map.put('R', 17);
        map.put('S', 18);
        map.put('T', 19);
        map.put('U', 20);
        map.put('V', 21);
        map.put('W', 22);
        map.put('X', 23);
        map.put('Y', 24);
        map.put('Z', 25);

        String name = "AAAAAAAAAA";
        Integer right = 0;
        Integer left = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);

        }

    }

    private static Integer find_minimum(Character c) {
        Integer characterIndex = map.get(c);
        return (Math.min(26 - characterIndex, characterIndex));
    }
}
