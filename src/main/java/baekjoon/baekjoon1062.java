package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class baekjoon1062 {
    private static int paragraph_num;
    private static int can_teach;
    private static int max = 0;
    private static Map<String, Boolean> remember = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        paragraph_num = Integer.parseInt(st.nextToken());
        can_teach = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < paragraph_num; i++) {
            String string = new StringTokenizer(br.readLine()).nextToken();
            string = string.substring(4, string.length() - 4);
            for (int j = 0; j < string.length(); j++) {
                remember.put(String.valueOf(string.charAt(j)), false);
            }
            list.add(string);
        }

        remember.put("a", true);
        remember.put("n", true);
        remember.put("t", true);
        remember.put("i", true);
        remember.put("c", true);

        System.out.println("list = " + list);

        move1062(0);

    }

    private static void move1062(int start) {
        if (start >= paragraph_num) {
            return;
        }

        for (int j = start; j < paragraph_num; j++) {
            System.out.println("j = " + j);
            move1062(start + 1);
//            0 -> 1 -> 2 -> 3 -> 4
        }
    }
}
