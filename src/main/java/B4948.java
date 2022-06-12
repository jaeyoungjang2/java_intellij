import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class B4948 {

    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        while (true) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0) {
                break;
            }
            list.add(i);
        }

        // 문제 풀이
        for (Integer integer : list) {
            int count = 0;
            // 소수의 개수 구하기
            for (int i = integer + 1; i <= integer * 2; i++) {
                if (isDecimal(i)) {
                    count ++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isDecimal(int i) {
        if (i <= 1) {
            return false;
        }
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
