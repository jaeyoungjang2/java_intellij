package programmers;

public class p12916 {

    public static void main(String[] args) {
        String s = "pyY";
        boolean answer = true;


        int pSize = 0;
        int ySize = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P') {
                pSize += 1;
                continue;
            }
            if (c == 'y' || c == 'Y') {
                ySize += 1;
                continue;
            }
        }

        if (pSize != ySize) {
            answer = false;
        }

        System.out.println(answer);
//        return answer;
    }
}
