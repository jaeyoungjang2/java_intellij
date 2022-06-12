package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class p43164_2 {
    private static boolean[] visit;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};

        visit = new boolean[tickets.length];
        Stack<String> stack = new Stack<>();
        stack.add("ICN");

        // index, 사용한 티켓의 수, stack
        dfs43164(0, stack, tickets);
        Collections.sort(result);
        System.out.println(result.get(0));
    }

    private static void dfs43164(int count, Stack<String> stack, String[][] tickets) {
        String currentAirport = stack.peek();
        if (count == tickets.length) {
            result.add(String.join(" ", stack));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 티켓을 사용하지 않았고, 티켓에 현재 스타트 지점이 있을 경우
            if (!visit[i] && tickets[i][0].equals(currentAirport)) {
                String nextAirport = tickets[i][1];
                visit[i] = true;
                stack.add(nextAirport);
                dfs43164(count + 1, stack, tickets);
                stack.pop();
                visit[i] = false;
            }
        }
    }
}
