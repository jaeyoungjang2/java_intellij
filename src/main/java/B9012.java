import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());


        for (int i = 0; i < cycle; i++) {
            String s = br.readLine();
            System.out.println(checkVps(s));
        }
    }

    private static String checkVps(String s) {
        int count = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if (c == '(') {
                count++;
                continue;
            }
            count--;
            if (count < 0) {
                return "NO";
            }
        }
        if (count == 0) {
            return "YES";
        }
        return "NO";
    }
}
