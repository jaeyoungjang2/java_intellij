import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean[] popArray = new boolean[100001];
        boolean isYes = true;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        // 다음값이 스택 마지막 값 보다 크다면 스택에 들어오고
        // 다음값이 스택 마지막 값 보다 작다면 스택에서 나가고
        for (int j = 0; j < cycle; j++) {
            int i = Integer.parseInt(br.readLine());
            // 새로운 수가 들어옴
            // 새로 들어온 수가 스택에 들어갈 수보다 작거나 같고, 스택의 마지막 수보다 크다면 No
            if (popArray[i]) {
                System.out.println("NO");
                isYes = false;
                break;
            }
            // 새로 들어온 수가 스택에 들어갈 수보다 크다면 스택에 push
            while (count <= i) {
                stack.push(count);
                count++;
                sb.append("+\n");
            }
            // 새로 들어온 수가 스택에 들어갈 수보다 작거나 같고, 스택의 마지막 수보다 작거나 같다면 pop
            while (count > i && !stack.isEmpty() && stack.peek() >= i) {
                Integer pop = stack.pop();
                System.out.println(pop);
                popArray[pop] = true;
                sb.append("-\n");
            }
        }
        if (isYes) {
            System.out.println(sb.toString());
        }
    }
}
