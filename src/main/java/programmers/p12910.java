package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p12910 {

    public static void main(String[] args) {
        int[] arr = {10, 5, 9, 7, 10};
        int divisor = 5;


        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }
        int[] answer;
        Collections.sort(list);
        if (list.size() == 0) {
            answer = new int[1];
        } else {
            answer = new int[list.size()];
        }

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

//        return answer;
    }
}
