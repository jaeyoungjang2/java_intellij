package programmers;

public class p12943 {

    public static void main(String[] args) {
        long num = 626331;

        int answer = 0;

        int index = 0;
        while (index <= 500 && num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                index ++;
                continue;
            }
            num = (num * 3) + 1;
            index ++;
        }

        if (num != 1) {

            System.out.println(-1);
            answer = -1;
//            return answer;
        }
        answer = index;
        System.out.println("index = " + index);
        System.out.println("num = " + num);
        System.out.println(answer);
//        return answer;
    }
}
