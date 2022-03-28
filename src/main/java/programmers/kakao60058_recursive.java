public class kakao60058_recursive {

    public static void main(String[] args) {
        //        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.
        String p = "()))((()";
        String result = "";
        result = splitUV(p, result);
        System.out.println(result);
    }

    private static String splitUV(String p, String result) {
        if (p.length() == 0) {
            return p;
        }

        int open = 0;
        int close = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                break;
            }
        }
        // 균형잡힌 괄호
        String u = p.substring(0, open + close);
        String v = p.substring(open + close);

        // 올바른 괄호이면
        if (u.charAt(0) == '(') {
            result += u + splitUV(v, result);
        } else {
            result = "(" + splitUV(v, result) + ")" + stringReverse(u.substring(1, u.length() - 1));
        }
        return result;
    }

    private static String stringReverse(String u) {
        String temp = "";
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                temp += ")";
            } else {
                temp += "(";
            }
        }
        return temp;
    }
}
