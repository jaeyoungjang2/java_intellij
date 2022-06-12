package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon16928 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ladder = new int[101];
        int[] snake = new int[101];

        int l = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        for (int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladder[start] = end;
        }

        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snake[start] = end;
        }

        int position = 1;
        boolean[] visit = new boolean[101];
        int[] answer = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(position);
        visit[1] = true;
        while (!queue.isEmpty()) {
            position = queue.remove();
            if (position == 100) {
                break;
            }

            // 주사위를 던진다.
            for (int i = 1; i <= 6; i++) {

                // 다음 위치 : 현재 위치에서 주사위 던진 숫자를 더함
                int newPosition = position + i;
                // 다음 가야할 위치가 종착지를 넘어선다면 넘어간다.
                if (newPosition > 100) {
                    continue;
                }
                // 다음위치에 사다리가 존재하면 , 위치 수정
                if (ladder[newPosition] != 0) {
                    newPosition = ladder[newPosition];
                }
                // 다음 위치에 뱀이 존재한다면 , 위치 수정
                if (snake[newPosition] != 0) {
                    newPosition = snake[newPosition];
                }
                // 이미 방문한 적이 없을때만 queue에 저장한다.
                if (!visit[newPosition]) {
                    answer[newPosition] = answer[position] + 1;
                    queue.add(newPosition);
                    visit[newPosition] = true;
                }
            }
        }
        System.out.println(answer[100]);
    }
}
