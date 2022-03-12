import java.util.Arrays;

public class prepareAllSearch3 {

    public static void main(String[] args) {
//        int brown = 10;
//        int yellow = 2;
//        int brown = 8;
//        int yellow = 1;
        int brown = 24;
        int yellow = 24;

        // 총 12개
        // 나타날 수 있는 경우의 수 [3, 4], [4, 3]
        int[] answer = {};
        int total = brown + yellow;

        for (int i = 3; i < total; i++) {
            int row = i;
            int col = total / i;
            if (total % i != 0 || col < 3) {
                continue;
            }

            int expectBrown = (2 * col) + 2 * (row - 2);
            if (brown == expectBrown) {
                answer = new int[] {row, col};
            }
        }
        System.out.println(Arrays.toString(answer));


    }
}
