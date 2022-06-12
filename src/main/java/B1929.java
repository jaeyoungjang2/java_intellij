import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);

        for (int i = start; i <= end; i++) {
            if (isDecimal(i)) {
                System.out.println(i);
            }
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
