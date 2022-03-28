public class Solution2 {

    public static void main(String[] args) {
        int[] dayMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int period = 98;

//        int month = 11;
//        int day = 27;
//        int month = 6;
//        int day = 22;

        int month = 1;
        int day = 18;

        day += period;
        while (true) {
            if (day <= dayMonth[month]) {
                break;
            }

            // 이번달은 몇일까지 있는지 확인
            int days = dayMonth[month];
            day -= days;
            month++;

            if (month > 12) {
                month = month % 12;
            }
        }
        System.out.printf("%s월 %s일", month, day);
    }
}
