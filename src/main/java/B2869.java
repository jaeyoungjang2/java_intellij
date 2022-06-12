import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] string = br.readLine().split(" ");

        Integer up = Integer.parseInt(string[0]);
        Integer down = Integer.parseInt(string[1]);
        Integer target = Integer.parseInt(string[2]);

        Integer oneday = up - down;
        int answer = 1;
        target -= up;

        int day = (int) Math.ceil(target / (double) oneday);
        answer += day;

        System.out.println(answer);
    }
}
