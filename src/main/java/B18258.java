import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cycle = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < cycle; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("push")) {
                deque.add(Integer.parseInt(st.nextToken()));
                continue;
            }

            if (command.equals("pop")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.remove() +"\n");
                continue;
            }

            if (command.equals("size")) {
                sb.append(deque.size() +"\n");
            }

            if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append("1\n");
                    continue;
                }
                sb.append("0\n");
            }

            if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.peekFirst() + "\n");
            }

            if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }
                sb.append(deque.peekLast() + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
