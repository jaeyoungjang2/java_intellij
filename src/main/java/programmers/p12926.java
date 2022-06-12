package programmers;

public class p12926 {

    public static void main(String[] args) {
//        String s = "AB";
        String s = "a B z";
        int n = 4;

//    시작
        String answer = "";

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < s.length(); i++) {
            Character currentCharacter = s.charAt(i);
            if (currentCharacter == ' ') {
                answer += " ";
                continue;
            }
            if (Character.isUpperCase(currentCharacter)) {
                answer += getNextCharacter(n, uppercase, currentCharacter);
                continue;
            }
            answer += getNextCharacter(n, lowercase, currentCharacter);
        }

        System.out.println(answer);
        System.out.println((char) (('b' - 'a')));
//    return answer;
    }

    private static char getNextCharacter(int moveIndex, String lowerAndUpperCase, Character currentCharacter) {
        // 현재 문자열의 위치
        int currentIndex = lowerAndUpperCase.indexOf(currentCharacter);

        // 이동해야 하는 문자열의 위치
        int nextIndex = currentIndex + moveIndex;
        // 이동해야 하는 문자열의 위치가 범위를 벗어나는 경우
        if (nextIndex > lowerAndUpperCase.length() - 1) {
            // 범위 재조정 ( 범위 재조정을 할 때는 %를 사용하는 것이 더 현명해 보임)
            nextIndex = nextIndex - (lowerAndUpperCase.length());
        }
        // 범위 재조정을 한 문자열 반환
        return lowerAndUpperCase.charAt(nextIndex);
    }
}
