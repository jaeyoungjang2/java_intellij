package programmers;

import java.util.regex.Pattern;

public class p72410 {

    public static void main(String[] args) {
//        String new_id = "...!@BaT#*..y.abcdefghijklm.";
//        String new_id = "z-+.^.";
//        String new_id = "=.=";
//        String new_id = "123_.def";
//        String new_id = "abcdefghijklmn.p";
//        String new_id = "!@##$%%^&^&&*(()_)+_.-";
        String new_id = "123456789";

        System.out.println("new_id = " + new_id);

        // 시작
        String answer = "";

        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String step1_new_id = "";
        step1_new_id = new_id.toLowerCase();
        System.out.println("step1_new_id = " + step1_new_id);

        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String regex_step2 = "[^a-z0-9-_.]*";
        String step2_new_id = step1_new_id.replaceAll(regex_step2, "");
        System.out.println("step2_new_id = " + step2_new_id);

        // 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String regex_step3 = "[.]{2,}";
        String step3_new_id = step2_new_id.replaceAll(regex_step3, ".");
        System.out.println("step3_new_id = " + step3_new_id);

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String regex_step4 = "^[.]|[.]$";
        String step4_new_id = step3_new_id.replaceAll(regex_step4, "");
        System.out.println("step4_new_id = " + step4_new_id);

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        String step5_new_id = step4_new_id;
        if (step4_new_id.length() == 0) {
            step5_new_id = "a";
        }
        System.out.println("step5_new_id = " + step5_new_id);

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        String step6_new_id = step5_new_id;
        if (step5_new_id.length() >= 16) {
            step6_new_id = step5_new_id.substring(0, 15);
        }
        System.out.println("step6_new_id = " + step6_new_id);

        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String step6_2_regex = "[.]$";
        String step6_2_new_id = step6_new_id.replaceAll(step6_2_regex, "");
        System.out.println("step6_2_new_id = " + step6_2_new_id);

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        String step7_new_id = step6_2_new_id;
        if (step7_new_id.length() <= 2) {
            while (step7_new_id.length() < 3) {
                step7_new_id += step7_new_id
                    .substring(step7_new_id.length() - 1, step7_new_id.length());
            }
        }
        System.out.println("step7_new_id = " + step7_new_id);

        answer = step7_new_id;
//        System.out.println(answer);
//        return answer;
    }

}
