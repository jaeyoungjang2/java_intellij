import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class prepareSort2 {
    private static int n;
    private static int[] info;
    private static boolean[] visit;
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) {

        int[] numbers = {6, 10, 2};
        n = numbers.length;
        info = new int[n];
        visit = new boolean[n];


        dfsSort2(0, numbers);
        Collections.sort(resultList);
        String answer = Integer.toString(resultList.get(resultList.size() - 1));
        System.out.println(answer);
        System.out.println(resultList);
    }

    private static void dfsSort2(int index, int[] numbers) {
        if (index == n) {
            String temp = "";
            for (int number: info) {
                temp += number;
            }
            resultList.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                info[index] = numbers[i];
                dfsSort2(index + 1, numbers);
                visit[i] = false;
            }
        }
    }
}
