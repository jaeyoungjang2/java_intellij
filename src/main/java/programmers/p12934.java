package programmers;

public class p12934 {

    public static void main(String[] args) {
        long n = 121;

        long answer = 0;

        double sqrt = Math.sqrt(n);
        System.out.println("sqrt = " + sqrt);

        if (Math.ceil(sqrt) != Math.floor(sqrt)) {
            answer = -1;
        } else {
            answer = (long) Math.pow(Math.ceil(sqrt) + 1, 2);
        }
//        return answer;
    }
}
