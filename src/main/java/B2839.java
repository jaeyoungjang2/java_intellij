import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B2839 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean success = false;
        int answer = -1;
        int divideFive = 0;
        int divideThree = 0;
        // 5로 1번

        divideFive = N / 5;
        while (divideFive >= 0) {
            if (success == true) {
                break;
            }
            int total = N - (5 * divideFive);
            if (total % 3 == 0) {
                success = true;
                divideThree = total / 3;
                answer = divideFive + divideThree;
            }
            divideFive --;
        }
        System.out.println(answer);
    }
}
