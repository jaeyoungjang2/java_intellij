import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B24479_깊이우선탐색1 {
    private static boolean[] visit;
    private static List<Integer>[] info;
    private static int[] record;
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        info = new List[N + 1];
        visit = new boolean[N + 1];
        record = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            info[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            info[from].add(to);
            info[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(info[i]);
        }
        visit[R] = true;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(record[i]);
        }
    }

    private static void dfs(int node) {
        record[node] = count;
        count ++;
        List<Integer> nextNodes = info[node];

        for (Integer nextNode : nextNodes) {
            if (!visit[nextNode]) {
                visit[nextNode] = true;
                dfs(nextNode);
            }
        }
    }
}
