package practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p12910 {

    public static void main(String[] args) {
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        List<Integer> collect = Arrays.stream(arr).filter(i -> i % divisor == 0).boxed()
            .collect(Collectors.toList());
        if (collect.size() == 0) {
//            return {-1};
            System.out.println();
        }


    }
}
