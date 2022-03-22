package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class p42840 {

    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};
//        int[] answers = {};
//        int[] answers = {5,4,4,2,1};
        int[] answers = {6, 6, 6, 6, 6, 6, 4, 3, 2};

        int[] search1 = {1, 2, 3, 4, 5};
        int[] search2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] search3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

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
            if (list.get(index) == max) {
                ranker.add(index + 1);
            }
        }

        int[] answer = new int[ranker.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = ranker.get(i);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
//        return answer;

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
