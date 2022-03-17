package programmers;



public class p12930 {

    public static void main(String[] args) {

        String s = " aba  ";

        String answer = "";

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += " ";
                index = 0;
                continue;
            }
            if (index % 2 == 0) {
                answer += Character.toUpperCase(s.charAt(i));
            }
            if (index % 2 == 0) {
                answer += Character.toLowerCase(s.charAt(i));
            }
        }

        System.out.println(answer);
//    return answer;
    }
}
