import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P72412_순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//        String[] info = {};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        Map<String, List<Integer>> record = new HashMap<>();
        int[] answer = new int[query.length];

        String[] languages = {"cpp", "java", "python", "-"};
        String[] workTypes = {"backend", "frontend", "-"};
        String[] careers = {"junior", "senior", "-"};
        String[] foods = {"chicken", "pizza", "-"};

        for (String language : languages) {
            for (String workType : workTypes) {
                for (String career : careers) {
                    for (String food : foods) {
                        String key = String
                            .format("%s and %s and %s and %s", language, workType, career, food);
//                        System.out.println(key);
                        record.put(key, new ArrayList<>());
                    }
                }
            }
        }

        for (String s : info) {
            String[] s1 = s.split(" ");

            int score = Integer.parseInt(s1[4]);

            for (String language : languages) {
                if (language.equals(s1[0]) || language.equals("-")) {
                    for (String workType : workTypes) {
                        if (workType.equals(s1[1]) || workType.equals("-")) {
                            for (String career : careers) {
                                if (career.equals(s1[2]) || career.equals("-")) {
                                    for (String food : foods) {
                                        if (food.equals(s1[3]) || food.equals("-")) {
                                            String key = String
                                                .format("%s and %s and %s and %s", language, workType, career, food);
                                            record.get(key).add(score);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (String key : record.keySet()) {
            Collections.sort(record.get(key));
        }

        int answerIndex = 0;
        for (String s : query) {
            String[] s1 = s.split(" ");
            int score = Integer.parseInt(s1[s1.length - 1]);
            int scoreLength = s1[s1.length - 1].length();
            List<Integer> scores = record.get(s.substring(0, s.length() - (scoreLength + 1)));

            String substring = s.substring(0, s.length() - (scoreLength + 1));
//            System.out.println("s = " + s);
//            System.out.println("substring = " + substring);
//            System.out.println("scores = " + scores);

            int left = 0;
            int right = scores.size() - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (score > scores.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

//            System.out.println("scores.size() = " + scores.size());
//            System.out.println(left - 1);
//            System.out.println("right = " + right);
            answer[answerIndex] = scores.size() - left;
            answerIndex ++;

        }
        for (int i : answer) {
            System.out.println("i = " + i);
        }
//        return answer;
    }
}
