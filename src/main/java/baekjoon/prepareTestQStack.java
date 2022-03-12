import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class prepareTestQStack {

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
//        int[] progresses = {99, 98, 97, 96};
//        int[] speeds = {100, 2, 2, 1};
//        int[] progresses = {95, 90, 99, 99, 80, 99};
//        int[] speeds = {1, 1, 1, 1, 1, 1};
//        int[] progresses = {5, 5, 5};
//        int[] speeds = {21, 25, 20};
//        int[] progresses = {95, 95, 95, 95};
//        int[] speeds = {4, 3, 2, 1};
//        int[] progresses = {99, 1};
//        int[] speeds = {1, 99};
        int[] progresses = {99, 1, 99, 1};
        int[] speeds = {1, 1, 1, 1};

        Queue<Integer> queue = new LinkedList<>();
        int day = progresses[0];
        int speed = speeds[0];
        int count = calculateDueDate(day, speed);
        int currentStandard = count;
        int currentCompleteProgress = 1;


        for (int i = 1; i < progresses.length; i++) {
            day = progresses[i];
            speed = speeds[i];

            count = calculateDueDate(day, speed);

            if (count <= currentStandard) {
                currentCompleteProgress ++;
            } else {
                // 현재 작업을 완료하는 날짜가 이전 작업을 완료하는 날짜보다 큰 경우
                // 이전 작업을 완료한 개수를 저장
                queue.add(currentCompleteProgress);
                currentStandard = count;
                currentCompleteProgress = 1;
            }
        }
        queue.add(currentCompleteProgress);
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            int number = queue.remove();
            answer[i] = number;
        }


        System.out.println(queue);
        System.out.println(Arrays.toString(answer));
    }

    private static int calculateDueDate(int day, int speed) {
        int count = 0;
        int complete = 100;
        while (day < complete) {
            day += speed;
            count++;
        }
        return count;
    }
}
