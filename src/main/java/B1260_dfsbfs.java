import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260_dfsbfs {
    private static boolean[] visit;
    private static List<Integer>[] record;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        record = new ArrayList[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            record[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            record[from].add(to);
            record[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(record[i]);
        }

        visit[V] = true;
        dfs(V);

        sb.append("\n");
        visit = new boolean[N + 1];
        visit[V] = true;
        bfs(V);
        System.out.println(sb.toString());
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer currentNode = queue.remove();
            sb.append(currentNode + " ");
            List<Integer> nextNodes = record[currentNode];

            for (Integer nextNode : nextNodes) {
                if (!visit[nextNode]) {
                    visit[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }

    private static void dfs(int start) {
        sb.append(start + " ");
        List<Integer> nextNodes = record[start];

        for (Integer nextNode : nextNodes) {
            if (!visit[nextNode]) {
                visit[nextNode] = true;
                dfs(nextNode);
            }
        }
    }

}
