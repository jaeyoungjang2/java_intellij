package practice;

import java.util.Arrays;

public class p12916 {

    public static void main(String[] args) {
        String s = "pPoooyY";
        String[] split = s.split("");
        long pCount = Arrays.stream(split).filter(factor -> factor.equals("p") || factor.equals("P"))
            .count();
        long yCount = Arrays.stream(split).filter(factor -> factor.equals("y") || factor.equals("Y"))
            .count();

        if (pCount == yCount) {
            System.out.println("true");
            System.exit(0);
        }
        System.out.println("false");
    }
}
