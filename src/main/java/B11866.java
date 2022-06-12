import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            list.add(i);
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            index += K - 1;
            if (index >= list.size()) {
                index %= list.size();
            }
            Integer remove = list.remove(index);
            sb.append(remove + ", ");
        }
        System.out.println("<" + sb.substring(0, sb.length() - 2) + ">");

    }
}
