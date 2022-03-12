import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class prepareSort1 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
//        [5, 6, 3]

        List<Integer> list = new ArrayList<>();
        for (Integer number: array) {
            list.add(number);
        }


        int[] answer = new int[3];
        int index = 0;
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];
            List<Integer> subList = new ArrayList<>(list.subList(start - 1, end));
            Collections.sort(subList);
            answer[index] = subList.get(target - 1);
            index ++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
