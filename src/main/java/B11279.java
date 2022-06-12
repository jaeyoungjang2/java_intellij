import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class B11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cycle = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> list = new PriorityQueue<>((Integer o1, Integer o2) -> (- Integer.compare(o1,o2)));
        for (int i = 0; i < cycle; i++) {
            int j = Integer.parseInt(br.readLine());
            if (j == 0) {
                if (list.size() == 0) {
                    sb.append("0\n");
                    continue;
                }
                // 최대값 위치

                sb.append(list.peek() + "\n");
                list.remove();
                continue;
            }
            list.add(j);
        }
        System.out.println(sb.toString());
    }
}
