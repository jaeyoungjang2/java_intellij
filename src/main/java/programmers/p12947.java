package programmers;

import java.util.Arrays;

public class p12947 {

    public static void main(String[] args) {

        int x = 13;

        System.out.println(hashard(x));
//        return hashard(x);
    }

    private static boolean hashard(int x) {
        String[] split = String.valueOf(x).split("");
        int total = Arrays.stream(split).mapToInt(Integer::parseInt).sum();
        return x % total == 0;
    }

}
