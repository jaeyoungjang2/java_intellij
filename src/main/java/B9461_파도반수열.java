import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9461_파도반수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cycle = Integer.parseInt(br.readLine());


        for (int i = 0; i < cycle; i++) {

            int i1 = Integer.parseInt(br.readLine());
            long[] record = new long[101];
            record[1] = 1;
            record[2] = 1;
            record[3] = 1;
            record[4] = 2;
            record[5] = 2;
            for (int j = 6; j <= i1; j++) {
                record[j] = record[j - 1] + record[j - 5];
            }
//            for (int j = 0; j <= i1; j++) {
//                System.out.print(record[j] + " ");
//            }
            System.out.println(record[i1]);
        }
    }
}
