package baekjoon;

import java.util.Arrays;

public class prepareSort2_1 {

    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        String[] numbers = {"6", "10", "2"};
//        int[] numbers = {3, 30, 34, 5, 9};
        int[] numbers = {0, 0, 0};
        String[] stringNumbers = new String[numbers.length];
        int index = 0;
        for (int number: numbers) {
            stringNumbers[index] = Integer.toString(number);
            index++;
        }
        Arrays.sort(stringNumbers, ((o1, o2) -> (o2 + o1).compareTo(o1 + o2)));

        String answer = "";
        for (String number: stringNumbers) {
            answer += number;
        }

        if (answer.startsWith("0")) {
            answer = "0";
        }
        System.out.println(answer);

    }


}
