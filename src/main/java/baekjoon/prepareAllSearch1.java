package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class prepareAllSearch1 {

    public static void main(String[] args) {
//        int[] answers = {1, 2, 3, 4, 5};
//        int[] answers = {1, 3, 2, 4, 2};
//        int[] answers = {};
        int[] answers = {1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 5, 5, 5, 5, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 5, 5, 5, 5, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 1, 3, 2, 4, 2, 5, 5, 5, 5};

        int[] search1 = {1, 2, 3, 4, 5};
        int[] search2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] search3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        List<Integer> list = new ArrayList<>(Arrays
            .asList(search1(answers, search1), search1(answers, search2),
                search1(answers, search3)));
        System.out.println(list);

        int max = 0;
        int maxCount = 0;

        for (Integer num : list) {
            if (num > max) {
                max = num;
                maxCount = 1;
            } else if (num == max) {
                maxCount++;
            }
        }

        int[] answer = new int[maxCount];

        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == max) {
                System.out.println(list.get(i));
                System.out.println("index:" +index);
                answer[index] = i + 1;
                index++;
            }

        }
        System.out.println(Arrays.toString(answer));


    }

    private static int search1(int[] answers, int[] search) {
        int searchLength = search.length;

        int matchCount = 0;
        int index = 0;
        for (int i = 0; i < answers.length; i++) {
            if (search[index] == answers[i]) {
                matchCount++;
            }
            index++;
            if (index == searchLength) {
                index = 0;
            }
        }
        return matchCount;
    }
}