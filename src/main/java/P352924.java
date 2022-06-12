import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P352924 {

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        int index = 0;
        for (Integer integer : list) {
            answer[index] = integer;
            index++;
        }
    }
}