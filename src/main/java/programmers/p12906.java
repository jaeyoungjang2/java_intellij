package programmers;

import java.util.ArrayList;
import java.util.List;

public class p12906 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};


        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int currentCount = arr[i];
            int beforeCount = list.get(list.size() - 1);
            if (currentCount != beforeCount) {
                list.add(currentCount);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

//        return answer;
    }
}
