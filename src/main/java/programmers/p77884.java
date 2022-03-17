package programmers;

public class p77884 {

    public static void main(String[] args) {
        int left = 24;
        int right = 27;

        // 시작
        int answer = 0;

        for (int i = left; i <= right; i++) {

            int countMeasure = calCountMeasure(i);
            if (countMeasure % 2 == 0) {
                answer += i;
                continue;
            }
            answer -= i;
        }

        // return answer;
    }

    private static int calCountMeasure(int i) {
        int countMeasure = 0;
        for (int j = 1; j <= i; j++) {
            if (i % j == 0) {
                countMeasure++;
            }
        }
        return countMeasure;
    }
}
