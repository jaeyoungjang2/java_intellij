public class P12909_올바른괄호 {

    public static void main(String[] args) {
        String s = "()()";
//        System.out.println(validation(s));
//        return validation(s);

    }

    private static boolean validation(String s) {
        int openCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount ++;
                continue;
            }
            openCount --;
            if (openCount < 0) {
                return false;
            }
        }
        if (openCount == 0) {
            return true;
        }
        return false;
    }

}
