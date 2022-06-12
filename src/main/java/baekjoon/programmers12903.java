package baekjoon;

public class programmers12903 {

    public static void main(String[] args) {
//        String s = "abcde";
        String s = "qwer";
        String answer = "";

        int stringLength = s.length();

        int middleIndex = s.length() / 2;
        answer = s.substring(middleIndex, (middleIndex) + 1);
        if (stringLength % 2 == 0) {
            answer = s.substring((middleIndex) - 1, (middleIndex) + 1);
        }

        System.out.println(answer);
//        return answer;

    }
}
