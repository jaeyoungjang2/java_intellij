import java.util.Arrays;

public class p42885 {

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 30, 60};
        int limit = 100;

        // 최대한 limit에 맞춰서 꽉꽉 넣어야함
        // 2명만 탈 수 있음
        // 30 50 50 70 80
        Arrays.sort(people);
        int frontIndex = 0;
        int endIndex = people.length - 1;
        int answer = 0;
        while (true) {
            if (frontIndex > endIndex) {
                break;
            }

            if (frontIndex == endIndex) {
                answer ++;
                break;
            }

            answer ++;
            if (people[frontIndex] + people[endIndex] > limit) {
                endIndex --;
                continue;
            }

            frontIndex ++;
            endIndex --;
        }
        System.out.println(answer);
    }
}