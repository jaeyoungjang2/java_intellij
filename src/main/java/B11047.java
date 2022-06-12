import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        Integer answer = 0;
        Integer lackMoney = K;
        while (true) {
            if (lackMoney.equals(0)) {
                break;
            }
            Integer money = stack.pop();
            int value = lackMoney / money;
            lackMoney -= money * value;
            answer += value;
        }
        System.out.println(answer);
    }
}
