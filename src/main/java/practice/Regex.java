public class Regex {

    public static void main(String[] args) {
        String test = "...!@BaT#*..y.abcdefghijklm.";
//        String test = "z-+.^.";
//        String test = "=.=";
//        String test = "123_.def";
//        String test = "abcdefghijklmn.p";

        System.out.println("test  = " + test);
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String step2Regex = "[^a-zA-Z-_.]";
        String step2 = test.replaceAll(step2Regex, "");
        System.out.println("step2 = " + step2);

//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String step3Regex = "[..]{2,}";
        String step3 = step2.replaceAll(step3Regex, ".");
        System.out.println("step3 = " + step3);

//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String step4Regex = "^[.]|[.]$";
        String step4 = step3.replaceAll(step4Regex, "");
        System.out.println("step4 = " + step4);

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//            만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String step6Regex = "[.]$";
        String substring = step4.substring(0, 15);
        String step6 = substring.replaceAll(step6Regex, "");
        System.out.println("step6 = " + step6);
    }
}
