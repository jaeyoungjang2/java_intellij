import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11053_가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        int[] procedures = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            procedures[i] = 1;
        }


        int maxProcedure = 0;
        for (int i = 0; i < N; i++) {
            int number = numbers[i];
            int maxIndex = 1;
            for (int j = 0; j < i; j++) {
                int compareNumber = numbers[j];
                int compareProcedure = procedures[j];
                if (compareNumber < number && compareProcedure >= maxIndex) {
                    maxIndex = compareProcedure + 1;
                    if (maxProcedure < maxIndex) {
                        maxProcedure = maxIndex;
                    }
                }
            }
            procedures[i] = maxIndex;
        }
        System.out.println(maxProcedure);

    }
}
