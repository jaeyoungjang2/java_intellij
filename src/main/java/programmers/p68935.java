package programmers;

public class p68935 {

    public static void main(String[] args) {
        int n = 125;

        int answer = 0;

        String temp = tenToThree(n, 3);

        answer = threeToTen(answer, temp);
        System.out.println(answer);
//        return answer;
    }

    private static int threeToTen(int answer, String temp) {
        for (int i = 0; i < temp.length(); i++) {
             answer += Character.getNumericValue(temp.charAt(i)) * Math.pow(3, temp.length() - (i + 1));
        }
        return answer;
    }

    private static String tenToThree(int n, int val) {
        String temp = "";
        while (n >= val) {
            temp += n % val;
            n /= val;
        }
        temp += n;
        return temp;
    }
}
