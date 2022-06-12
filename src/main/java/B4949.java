import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            // 점 한개만 들어오면 종료
            if (s.length() == 1 && s.equals(".")) {
                break;
            }

            System.out.println(isVps2(s));


            }
        }
    private static String isVps2(String s) {
        Stack<Character> stack = new Stack<>();
        int large = 0;
        int small = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
                continue;
            }
            if (s.charAt(i) == '[') {
                stack.add('[');
                continue;
            }
            if (s.charAt(i) == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                stack.pop();
            }
            if (s.charAt(i) == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        }
        return "no";
    }
}
