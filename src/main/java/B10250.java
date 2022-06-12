import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());

        for (int i = 0; i < cycle; i++) {
            String[] s = br.readLine().split(" ");
            int H = Integer.parseInt(s[0]);
            int W = Integer.parseInt(s[1]);
            int N = Integer.parseInt(s[2]);

            if (N % H == 0) {
                System.out.println((H * 100) + (N / H));

            } else {
                System.out.println(((N % H) * 100) + ((N / H) + 1));
            }


            int floor = 0;
            int unit = 0;
            if (N % H == 0) {
                floor = H * 100;
                unit = N / H;
            } else {
                floor = N % H * 100;
                unit = (N / H) + 1;
            }

            System.out.print(floor + unit);
        }
    }
}
