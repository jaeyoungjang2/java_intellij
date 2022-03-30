package programmers;

public class p12931 {

    public static void main(String[] args) {

        int n = 123;
        int answer = 0;

        String string = String.valueOf(n);
        for (int i = 0; i < string.length(); i++) {
            answer += Character.getNumericValue(string.charAt(i));
        }

        System.out.println(answer);
//        return answer;


    }
}
