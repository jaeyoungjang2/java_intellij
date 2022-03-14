package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p42889 {

    public static void main(String[] args) {

//        int N = 5;
//        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

//        int N = 4;
//        int[] stages = {4, 4, 4, 4, 4};

        int N = 6;
        int[] stages = {1, 4, 4, 4};

        // key: 스테이지, value: 통과, 또는 멈춰 있는 사람수
        Map<Integer, Integer> clearUser = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            clearUser.put(i, 0);
        }

        // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        boolean[] visit = new boolean[N];
        int[] answer = new int[N];

        for (int i = 0; i < stages.length; i++) {
            int currentStage = stages[i];
            // 현재 스테이지 까지 도달
            for (int j = 1; j <= currentStage; j++) {
                clearUser.put(j, clearUser.getOrDefault(j, 0) + 1);
            }
        }

        List<Double> failRate = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int currentStage = i;

            int state = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == currentStage) {
                    state ++;
                }
            }

            if (clearUser.get(i) != 0) {
                double fail = state / (double) clearUser.get(i);
                failRate.add(fail);
            } else {
                failRate.add(0.0);
            }



        }

        System.out.println("failRate = " + failRate);
        List<Double> list = new ArrayList<>(failRate);
        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (!visit[j] && failRate.get(j) == list.get(i)) {
                    visit[j] = true;
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
