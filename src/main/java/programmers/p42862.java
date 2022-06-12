package programmers;

import java.util.Arrays;

public class p42862 {

    public static void main(String[] args) {
//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {1, 3, 5};

//        int n = 5;
//        int[] lost = {2, 4};
//        int[] reserve = {3};
//        int n = 5;
//        int[] lost = {};
//        int[] reserve = {};

        int n = 7;
        int[] lost = {2, 3, 4};
        int[] reserve = {1, 2, 3, 6};

        boolean[] visit = new boolean[n + 1];

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int answer = n - lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    // 자기 자신에게 이미 줌
                    visit[lost[i]] = true;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            
        }
    }
}
