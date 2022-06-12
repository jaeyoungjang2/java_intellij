package programmers;

public class p12928 {

    public static void main(String[] args) {
        int n = 5;
        
        // 시작
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        System.out.println("answer = " + answer);
        // return answer;
    }
}
