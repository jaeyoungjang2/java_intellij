package programmers;

import java.util.Arrays;

public class p12935 {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};


        int[] answer;

        if (arr.length == 1) {
            answer = new int[] {-1};
//            return answer;
        }

        answer = new int[arr.length - 1];
        int index = 0;
        int minimumNum = Arrays.stream(arr).min().getAsInt();
        for (int num: arr) {
            System.out.println("num = " + num);
            if (num == minimumNum) {
                continue;
            }
            answer[index] = num;
            index++;
        }

        for (int i : answer) {
            System.out.println("i = " + i);
        }
//        return answer;
    }
}
