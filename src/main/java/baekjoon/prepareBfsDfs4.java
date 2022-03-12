import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class prepareBfsDfs4 {

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "AOO"},{"AOO", "BOO"},{"BOO", "COO"},{"COO", "DOO"},
        {"DOO", "EOO"},{"EOO", "DOO"},{"DOO", "COO"}, {"COO", "BOO"},{"BOO", "AOO"}};
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
//            {"ATL", "SFO"}};


        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> countInfo = new HashMap<>();
        Map<String, Integer> relationInfo = new HashMap<>();

        for (int i = 0; i < tickets.length; i++) {
            String from = tickets[i][0];
            String to = tickets[i][1];
            map.put(from, map.getOrDefault(from, new ArrayList<>()));
            map.get(from).add(to);
            countInfo.put(from, countInfo.getOrDefault(from, 0));
            relationInfo.put(from+"_"+to, relationInfo.getOrDefault(from+"_"+to, 0) + 1);
        }

        for (String from: map.keySet()) {
            List<String> valueList = map.get(from);
            Collections.sort(valueList);
            map.put(from, valueList);
        }
        String[] answer = new String[tickets.length + 1];
        dfs4(map, countInfo, "ICN", 0, tickets.length, answer, relationInfo);
        System.out.println(Arrays.toString(answer));
    }

    private static void dfs4(Map<String, List<String>> map, Map<String, Integer> countInfo, String from, int index, int end, String[] answer, Map<String, Integer> relationInfo) {
        answer[index] = from;
        if (index == end) {
            System.out.println(Arrays.toString(answer));
            System.exit(0);
            return;
        }

        List<String> toGoList = map.get(from);
        for (String to: toGoList) {
//            System.out.println();
//            System.out.println(toGoList);
//            System.out.println(Arrays.toString(answer));
//            System.out.println(from);
//            System.out.println(to);
//            System.out.println(relationInfo.get(from+"_"+to));
            if (relationInfo.get(from+"_"+to) <= 0) {
                continue;
            }
            relationInfo.put(from+"_"+to, relationInfo.get(from+"_"+to) - 1);

            dfs4(map, countInfo, to, index + 1, end, answer, relationInfo);
            relationInfo.put(from+"_"+to, relationInfo.get(from+"_"+to) - +1);
        }
    }
}
