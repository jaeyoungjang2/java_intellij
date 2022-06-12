import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B2579_계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int floor = Integer.parseInt(br.readLine());

        int[][] record = new int[floor + 1][3];

        int[] stairs = new int[floor + 1];
        for (int i = 1; i <= floor; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= floor; i++) {
            int score = stairs[i];
            record[i][0] = Math.max(record[i - 1][1], record[i - 1][2]);
            // 현재 계단이 첫번째 계단이 되는 경우 = 이전 계단을 안 밟았을 때의 score + 현재 계단을 밟았을 때의 score
            record[i][1] = record[i - 1][0] + score;
            // 현재 계단이 두번째 계단이 되는 경우 = 이전 계단을 첫 번째 밟았을 때의 score + 현재 계단을 밟았을 때의 score
            record[i][2] = Math.max(record[i - 1][1], record[i - 1][0]) + score;
        }

        int max = 0;
        for (int i = 1; i < 3; i++) {
            max = Math.max(max, record[floor][i]);
        }
        System.out.println(max);

//        for (int i = 0; i <= floor; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(record[i][j]+ " ");
//            }
//            System.out.println();
//        }
//        System.out.println(max);
    }
}