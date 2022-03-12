import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class baekjoon1987 {
    private static String[][] info;
    private static int max = 0;
    private static int row;
    private static int col;
    private static int[] xAxis = {-1, 1, 0, 0};
    private static int[] yAxis = {0, 0, -1, 1};
    private static boolean[][] visit;
    private static Map<String, Boolean> remember = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        2 4
//        CAAB
//        ADCB
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        info = new String[row][col];
        visit = new boolean[row][col];


        for (int i = 0; i < row; i++) {
            String string = new StringTokenizer(br.readLine()).nextToken();

            for (int j = 0; j < col; j++) {
                String alphabet = String.valueOf(string.charAt(j));
                info[i][j] = alphabet;
                remember.put(alphabet, false);
            }
        }
        visit[0][0] = true;
        remember.put(info[0][0], true);
        move1987(0, 0, 1);
        System.out.println(max);
    }

    private static void move1987(int x, int y, int count) {
        // 현재 위치가 최대 이동거리일 경우 저장
        if (count > max) {
            max = count;
        }

        // 상, 하, 좌, 우로 이동
        for (int i = 0; i < 4; i++) {
            int newX = x + xAxis[i];
            int newY = y + yAxis[i];
            // 현재 좌표가 범위를 벗어난다면 돌아가기
            if (newX < 0 || newY < 0 || newX >= row || newY >= col) {
                continue;
            }
            // 범위를 벗어나지 않을 경우
            if (!visit[newX][newY] && !remember.get(info[newX][newY])) {
                visit[newX][newY] = true;
                remember.put(info[newX][newY], true);
                move1987(newX, newY, count + 1);
                visit[newX][newY] = false;
                remember.put(info[newX][newY], false);
            }
        }


    }

}
