package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class p42748 {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = new int[commands.length];
        
        for (Integer integer : array) {
            list.add(integer);
        }
        
        for (int i = 0; i <commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1];
            int target = commands[i][2] - 1;

            List<Integer> temp = new ArrayList<>(list.subList(start, end));
            Collections.sort(temp);
            Integer integer = temp.get(target);
            answer[i] = integer;
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println("answer[i] = " + answer[i]);
        }
    }
}
