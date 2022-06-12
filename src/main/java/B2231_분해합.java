import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231_분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());

        int i1 = (int) (i * 0.1);
        i1 = Math.max(i1, 9 * String.valueOf(i).length());

        int answer = 0;
        for (int j = Math.max(0, i - i1); j < i; j++) {
            String s = String.valueOf(j);
            Integer temp = 0;
            for (int k = 0; k < s.length(); k++) {
                temp += Integer.parseInt(String.valueOf(s.charAt(k)));
            }
            if (j + temp == i) {
                answer = j;
                break;
            }
        }
        System.out.println(answer);

    }
}
