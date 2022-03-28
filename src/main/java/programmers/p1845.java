package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class p1845 {

    private static boolean[] visit;
    // 잡을 수 있는 마리의 수
    private static int threthold = 0;
    private static int max = 0;

    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3};

        // 시작
        threthold = nums.length / 2;
        visit = new boolean[nums.length];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() < threthold) {
            System.out.println(set.size());
            System.exit(0);
//            return set.size();
        }
        System.out.println(threthold);
//        return threthold;
    }
}
