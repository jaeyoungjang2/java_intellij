import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class B1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        List<Integer> list2 = new ArrayList<>();

        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            // 앞에서 뽑을지, 뒤에서 뽑을지 정해야함

            int frontSize = list.subList(0, list.indexOf(target)).size();
            int backSize = list.subList(list.indexOf(target), list.size()).size();
            answer += Math.min(frontSize, backSize);

            list2.addAll(list.subList(list.indexOf(target), list.size()));
            list2.addAll(list.subList(0, list.indexOf(target)));

            list = list2;
            list.remove(0);
            list2 = new ArrayList<>();
        }
        System.out.println(answer);

    }
}
