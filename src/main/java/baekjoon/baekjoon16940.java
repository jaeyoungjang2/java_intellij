package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        boolean[] visit = new boolean[n + 1];

        // stack 초기화
        // 1부터 n까지 스택을 초기화 해놓는다.
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        // node 정보를 저장해 놓는다.
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        int firstNode = Integer.parseInt(st.nextToken());
        if (firstNode != 1) {
            System.out.println(0);
            System.exit(0);
        }

        int[] info = new int[n + 1];

        // 첫번째 노드 저장
        queue.add(firstNode);
        // 첫번째 노드는 방문 완료했으니 , 재 방문은 없을 예정
        visit[firstNode] = true;
        while (!queue.isEmpty()) {
            // 현재 노드 꺼내고
            Integer currentNode = queue.remove();
            // 현재 노드에서 갈 수 있는 다음 노드를 확인해보자.
            int getNextEdgeCount = 0;
            for (int i = 0; i < list.get(currentNode).size(); i++) {

                if (!visit[list.get(currentNode).get(i)]) {
                    getNextEdgeCount++;
                    visit[list.get(currentNode).get(i)] = true;
                    info[list.get(currentNode).get(i)] = currentNode;
                }
            }

            // 갈 수 있는 노드의 수 만큼, 문제의 노드도 받아오자
            for (int i = 0; i < getNextEdgeCount; i++) {
                int nextNode = Integer.parseInt(st.nextToken());
                System.out.printf("%s -> %s \n", currentNode, nextNode);
                if (info[nextNode] != currentNode) {
                    System.out.println(0);
                    System.exit(0);
                }
                queue.add(nextNode);
            }
        }
        System.out.println(1);
    }
}
