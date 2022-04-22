import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

//         String name = "BBBBAAAAAB"; // 10
//        String name = "BBAAAAAAAABBBB";
        String name = "JAZ";

        List<Integer> list = new ArrayList<>();
        list.add(cal(name, 0));

        for (int i = 0; i < name.length() - 1; i++) {
            String first = name.substring(0,i + 2);
            String firstRemain = name.substring(i + 2, name.length());
            String last = name.substring(name.length() - 1 - i, name.length());
            String lastRemain = name.substring(0, name.length() - 1 - i);
            String moveLeft = firstRemain + first;
            StringBuilder sb = new StringBuilder();
            sb.append(moveLeft);
            moveLeft = sb.reverse().toString();
            System.out.println(moveLeft);
            String moveRight = last + lastRemain;
            System.out.println(moveRight);
            list.add(Math.min(cal(moveLeft, i + 1), cal(moveRight, i + 1)));
        }
        System.out.println(list);
        System.out.println(Collections.min(list));

    }

    private static int cal(String name, int add) {
        int moveControl = 0;
        int result = add;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c != 'A') {
                result += Math.min(map.get(c), 26 - map.get(c)) + moveControl;
                moveControl = 0;
            }
            moveControl ++;
        }
        return result;
    }
}