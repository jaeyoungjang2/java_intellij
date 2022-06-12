import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack();
        for (int i = 0; i < cycle; i++) {
            int number = Integer.parseInt(br.readLine());
            if (number == 0 && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.add(number);
        }

        int answer = 0;
        for (Integer integer : stack) {
            answer += integer;
        }

        System.out.println(answer);
    }
}
