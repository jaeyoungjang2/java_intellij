import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class programmers86051 {

    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] numbers = {5,8,4,0,6,7,9};
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(number);
        }

        for (int i = 0; i <= 9; i++) {
            if (list.contains(i)) {
                continue;
            }
            answer += i;
        }

        System.out.println(answer);
//        return answer;
    }
}
