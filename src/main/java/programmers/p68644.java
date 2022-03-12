package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p68644 {

    public static void main(String[] args) {
//        int[] numbers = {2, 1, 3, 4, 1};
        int[] numbers = {5, 0, 2, 7};
//        int[] numbers = {1, 4, 5, 13};

        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[result.size()];
        List<Integer> list = new ArrayList<>(result);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }


        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
//        return answer;
    }
}
