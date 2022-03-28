import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class p43164 {
    private static Map<String, List<String>> map = new HashMap<>();
    private static Map<String, Integer> visit = new HashMap<>();
    private static int airportCount;
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"}, {"ATL","SFO"}};
//        String[][] tickets = {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}};
        String[][] tickets = {{"ICN", "SFO"}, {"SFO", "ICN"}, {"ICN", "SFO"}, {"SFO", "QRE"}};


        for (int i = 0; i < tickets.length; i++) {
            String start = tickets[i][0];
            String end = tickets[i][1];
            try {
                map.get(start).add(end);
            } catch (Exception e) {
                map.put(start, new ArrayList<>());
                map.get(start).add(end);
            }
            try {
                visit.put(start + "_" + end, visit.get(start + "_" + end) + 1);
            } catch (Exception e) {
                visit.put(start + "_" + end, 1);
            }

        }
//        System.out.println("visit.get(\"ICN_SFO\") = " + visit.get("ICN_SFO"));
//        System.out.println("visit.get(\"SFO_ICN\") = " + visit.get("SFO_ICN"));
//        System.out.println("visit.get(\"SFO_QRE\") = " + visit.get("SFO_QRE"));
//        System.out.println("map.get(\"ICN\") = " + map.get("ICN"));
        airportCount = tickets.length;

        Stack<String> stack = new Stack<>();
        stack.add("ICN");
        // index, 이동한 공항의 수, 공항 이동 경로
        dfs43164(0, 0, stack, "ICN");
        Collections.sort(result);

        System.out.println(result.get(0));
        String[] s = result.get(0).split(" ");

    }

    private static void dfs43164(int index, int count, Stack<String> stack, String currentAirport) {
//        System.out.printf("%s, %s\n", count, currentAirport);
        if (count == airportCount) {
            List<String> list = new ArrayList<>(stack);
            String join = String.join(" ", list);
            result.add(join);
            return;
        }

        if (!map.containsKey(currentAirport)) {
            return;
        }

        for (int i = 0; i < map.get(currentAirport).size(); i++) {
            String nextAirport = map.get(currentAirport).get(i);
            if (visit.get(currentAirport+"_"+nextAirport) != 0) {
                visit.put(currentAirport+"_"+nextAirport, visit.get(currentAirport+"_"+nextAirport) - 1);
                stack.add(nextAirport);
                dfs43164(index + 1, count + 1, stack, nextAirport);
                visit.put(currentAirport+"_"+nextAirport, visit.get(currentAirport+"_"+nextAirport) + 1);
                stack.pop();
            }
        }
    }
}
