import java.io.IOException;
import java.util.Scanner;

public class B1011 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cycle = sc.nextInt();

        for (int i = 0; i < cycle; i++) {

            long start = sc.nextLong();
            long end = sc.nextLong();

            long distance = end - start;

            int max = (int)Math.sqrt(distance);	// 소수점 버림

            if(max == Math.sqrt(distance)) {
                System.out.println(max * 2 - 1);
            }
            else if(distance <= max * max + max) {
                System.out.println(max * 2);
            }
            else {
                System.out.println(max * 2 + 1);
            }
        }
    }
}
