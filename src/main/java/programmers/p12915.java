import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p12915 {

    public static void main(String[] args) {
        int[] answers = {
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3,
            1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3
        };

        int[] search1 = {1};
        int[] search2 = {2};
        int[] search3 = {3};

        // 각자 맞은 문제를 확인
        int count1 = search(search1, answers);
        int count2 = search(search2, answers);
        int count3 = search(search3, answers);

        // 사람 순서대로 맞춘 문제수를 집어 넣음
        List<Integer> list = new ArrayList<>(Arrays.asList(count1, count2, count3));
        // 제일 많이 맞춘 사람의 문제 수
        Integer max = Collections.max(list);

        // 최고득점자 저장
        List<Integer> ranker = new ArrayList<>();
        for (int index = 0; index < 3; index++) {
            System.out.println(list.get(index) == max);
            System.out.println(list.get(index).equals(max));
            if (list.get(index).equals(max)) {
                ranker.add(index + 1);
            }
        }

        int[] answer = new int[ranker.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ranker.get(i);
        }

        System.out.println(answer);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }

    private static int search(int[] search1, int[] answers) {

        int count = 0;
        int index = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == search1[index]) {
                count ++;
            }
            index++;
            if (index == search1.length) {
                index = 0;
            }
        }
        return count;
    }
}
