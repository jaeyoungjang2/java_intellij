package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class p12977 {

//    더한 값들을 저장
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] visit;
    private static int result = 0;

    public static void main(String[] args) {


//        int[] nums = {1, 2, 3, 4};
        int[] nums = {1, 2, 7, 6, 4};
        visit = new boolean[nums.length];

        int answer = 0;

        for (int num : nums) {
            list.add(num);
        }

        // index, 몇번 더했는 지, total
        permutation(0, 0, 0);

        System.out.println(result);
//         return result;

    }

    private static boolean isDecimal(int value) {

        for (int j = 2; j <= Math.sqrt(value); j++) {
            if (value % j == 0) {
                return false;
            }
        }
        return true;
    }

    private static void permutation(int index, int count, int total) {
        if (count == 3) {
            if (isDecimal(total)) {
                result ++;
            }
            return;
        }

        if (index > list.size()) {
            return;
        }

        for (int i = index; i < list.size(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                total += list.get(i);
                permutation(i + 1, count + 1, total);
                total -= list.get(i);
                visit[i] = false;
            }
        }
    }
}
