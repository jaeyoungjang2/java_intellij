import java.util.ArrayList;
import java.util.List;

public class kakao60058 {

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
//        String s = "()))((()";
//        String s = "))(())((";
//        String s = "()(())";
//        String s = ")))(((";
        String s = "(()))(";

        // ))(( ))((
        // u = ))(( v = ()()
        // (()())()
        String result = "";

        // 균형잡힌 문자 리스트를 얻는다.
        List<String> list = get_balance_list(s);

        for (int i = list.size() - 1; i >= 0; i--) {
            // u가 올바른 리스트면 그대로 결과를 넣고
            if (is_Correct_String(list.get(i))) {
                result = list.get(i) + result;

            } else {
                // 올바른 리스트가 아니라면
                // result는 v
                result = "(" + result + ")" + getContray(
                    list.get(i).substring(1, list.get(i).length() - 1));
            }
        }
        System.out.println("result = " + result);
    }

    private static String getContray(String substring) {
        String temp = "";
        for (int i = 0; i < substring.length(); i++) {
            if (substring.charAt(i) == '(') {
                temp += ')';
            } else {
                temp += '(';
            }
        }
        return temp;
    }

    private static boolean is_Correct_String(String s) {
        if (s.charAt(0) != '(') {
            return false;
        }
        return true;
    }

    private static List<String> get_balance_list(String s) {
        List<String> list = new ArrayList<>();
        String temp = "";
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
            }
            temp += s.charAt(i);

            if (count == 0) {
                list.add(temp);
                temp = "";
            }
        }
        return list;
    }
}
