import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class prepareTestHeap2 {
    private static boolean[] visit;
    private static int[] route;
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {
//        int[][] jobs = {{0, 3},{1, 9},{2, 6}};
        int[][] jobs = {{0, 1},{1, 6},{5, 1}};
        int answer = 0;

        visit = new boolean[jobs.length];
        route = new int[jobs.length];

        dfsHeap2(0, jobs);
        Collections.sort(resultList);
        System.out.println(resultList.get(0));
        System.out.println(resultList.get(0) / jobs.length);
    }

    private static void dfsHeap2(int index, int[][] jobs) {
        int endIndex = jobs.length;
        if (index == endIndex) {
            System.out.println(Arrays.toString(route));
            int answer = 0;
            int target = route[0];
            int durationTime = jobs[target][1];
            int currentTime = jobs[target][0] + durationTime;
            answer += durationTime;
            System.out.println(answer);
            for (int i = 1; i < route.length; i++) {
                target = route[i];
                int watingTime = currentTime - target;
                durationTime = jobs[target][1];
                if (watingTime >= 0) {
                    currentTime += durationTime;
                    answer += watingTime + durationTime;
                    System.out.println("watingTime: " + watingTime);
                    System.out.println("durationTime: " + durationTime);
                    System.out.println(answer);
                    continue;
                }
                currentTime = jobs[target][0] + durationTime;
                answer += durationTime;
                System.out.println(answer);
            }
            System.out.println("answer: " + answer);
            System.out.println();
            resultList.add(answer);
            return;
        }

        for (int i = 0; i < endIndex; i++) {
            if (!visit[i]) {
                visit[i] = true;
                route[index] = i;
                dfsHeap2(index + 1, jobs);
                visit[i] = false;
            }
        }
    }
}