import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class B11066 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());
        // i, i + 1, i, i + 1, i + 2
        // i, i + 2, i, i + 2, i + 1

        for (int i = 0; i < cycle; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> list = new ArrayList<>();
            List<Integer> files = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < N; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);
            files.add(list.get(0) + list.get(1));
            for (int j = 2; j < N; j++) {
                files.add(files.get(files.size() - 1) + list.get(j));
            }
            System.out.println(files);

            for (Integer file : files) {
                sum += file;
            }
            System.out.println(sum);

        }
    }
}
