import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class wwa01 {

    public static void main(String[] args) {
//        int[] arr = {2, 1, 3, 1, 2, 1};
//        int[] arr = {3, 3, 3, 3, 3, 3};
//        int[] arr = {1, 2, 3};
//        int[] arr = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
//        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] arr = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
//        int[] arr = {1};
//        int[] arr = {2};
        int[] arr = {3};

        int[] answer = new int[3];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 3; i++) {
            map.put(i, 0);
        }

        for (int number : arr) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        int maxNum = 0;
        for (int number: map.keySet()) {
            int value = map.get(number);
            if (maxNum < value) {
                maxNum = value;
            }
        }

        for (int i = 1; i <= 3; i++) {
            int value = map.get(i);
            int difference = maxNum - value;
            answer[i - 1] = difference;
        }

        System.out.println(Arrays.toString(answer));
    }

}
