import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class P92334 {

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = new int[id_list.length];

        // 신고한 사람
        // 내가 신고한 사람이 몇 명 정지당했는지 결과 저장
        Map<String, Integer> result = new HashMap<>();
        // 누구한테 신고당했는 지를 저장
        Map<String, Set<String>> reported = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            result.put(user, 0);
            reported.put(user, new HashSet());
        }

        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        System.out.println(list);

        // 신고 당한 사람
        // 누구한테 신고를 당했는 지 저장
        for (int i = 0; i < report.length; i++) {
            String from = report[i].split(" ")[0];
            String to = report[i].split(" ")[1];
            reported.get(to).add(from);
        }

        // 정지당한 사람이 있으면 결과에 저장
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            if (reported.get(user).size() >= k) {
                Set<String> reportUsers = reported.get(user);
                for (String reportUser : reportUsers) {
                    result.put(reportUser, result.get(reportUser) + 1);
                }

            }
        }

        // 신고자에게 누가 정지를 당했는지 알려줌
        for (int i = 0; i < id_list.length; i++) {
            String user = id_list[i];
            answer[i] = result.get(user);
        }

        System.out.println(reported);
//        return answer;
    }
}