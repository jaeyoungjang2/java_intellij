import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class p42883_2 {

    public static void main(String[] args) {
        String number = "654321";
        int k = 5;

        String answer = "";
        Stack<Integer> stack = new Stack();
        int popCount = 0;
        boolean isPop = false;
        for (int i = 0; i < number.length(); i++) {
            if (popCount == k) {
                // 나머지를 모두 넣고 종료
                for (Integer integer : stack) {
                    answer += integer;
                }
                answer += number.substring(i, number.length());
                isPop = true;
                break;
            }

            int num = Character.getNumericValue(number.charAt(i));
            while (!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                popCount ++;
                if (popCount == k) {
                    break;
                }
            }

            stack.add(num);
        }

        if (!isPop) {
            for (Integer integer : stack) {
                answer += integer;
            }
        }

        if (answer.length() > number.length() - k) {
            answer = answer.substring(0, number.length() - k);
        }
        System.out.println(answer);
    }
}
