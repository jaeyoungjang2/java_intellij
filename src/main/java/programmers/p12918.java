package programmers;

public class p12918 {

    public static void main(String[] args) {
//        String s = "a234";

//        false 이어야 하는데 지금 true로 나오고 있음
        String s = "eeee";

        boolean answer = false;

        if (lengthCheck(s) && digitCheck(s)) {
            answer = true;
        }
        System.out.println(answer);
//        return answer;
    }

    private static boolean digitCheck(String s) {
        return s.chars().allMatch(Character::isDigit);
    }

    private static boolean lengthCheck(String s) {

        if (s.length() == 4 || s.length() == 6) {
            return true;
        }
        return false;
    }
}
