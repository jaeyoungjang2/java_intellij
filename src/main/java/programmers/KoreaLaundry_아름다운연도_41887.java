package programmers;

import java.util.HashSet;
import java.util.Set;

public class KoreaLaundry_아름다운연도_41887 {

    public static void main(String[] args) {
        // 시간 초과
        int p = 1987; // 2013
//        int p = 2015; // 2016
//        int p = 9000;
//        int p = 9901;

        // 해당 연도보다 큰 수부터 시작한다.
        p = p + 1;
        int answer = p;

        for (int i = p; i <= 10000; i++) {
            int temp = i;
            Set<Integer> set = new HashSet<>();
            while (temp != 0) {
                if (set.contains(temp % 10)) {
                break;
                }
                set.add(temp % 10);
                temp /= 10;
            }

            if (set.stream().count() == String.valueOf(i).length()) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}


//while (true) {
//    int temp = p;
//    set = new HashSet<>();
//
//    while (temp != 0) {
//    if (set.contains(temp % 10)) {
//    break;
//    }
//    set.add(temp % 10);
//    temp /= 10;
//    }
//
//    // 아름다운 연도일 경우 종료
//    if (set.stream().count() == String.valueOf(p).length()) {
//    break;
//    }
//
//    p ++;
//    }
//    System.out.println(p);