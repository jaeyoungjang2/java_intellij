package programmers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class p12901 {

    public static void main(String[] args) {
        String answer = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(7, "SON");
        map.put(1, "MON");
        map.put(2, "TUE");
        map.put(3, "WED");
        map.put(4, "THU");
        map.put(5, "FRI");
        map.put(6, "SAT");

        int a = 5;
        int b = 24;

        LocalDate date = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int day = dayOfWeek.getValue();
        answer = map.get(day);
        System.out.println(answer);
//        return answer;

    }
}
