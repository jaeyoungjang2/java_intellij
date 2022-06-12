package baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class prepareBfsDfs3 {
    private static boolean[] visit;

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
//        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words = {"hot", "dot", "dog", "lot", "log"};
        int answer = 0;

        visit = new boolean[words.length];

        answer = bfs3(begin, target, words);
        System.out.println(answer);
    }

    private static boolean compare(String begin, String word) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                diff++;
            }
        }
        if (diff == 1) {
            return true;
        }
        return false;
    }

    private static int bfs3(String begin, String target, String[] words) {
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(begin, 0));

        while (!queue.isEmpty()) {
            Info currentInfo = queue.remove();
            String current = currentInfo.name;
            int distance = currentInfo.distance;

            if (current.equals(target)) {
                return distance;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visit[i] && compare(current, words[i])) {
                    visit[i] = true;
                    int nextDistance = distance + 1;
                    String next = words[i];
                    queue.add(new Info(next, nextDistance));
                }
            }
        }
        return 0;
    }
}

class Info {
    String name;
    int distance;

    public Info(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }
}
