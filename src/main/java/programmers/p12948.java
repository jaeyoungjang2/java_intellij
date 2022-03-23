package programmers;

public class p12948 {

    public static void main(String[] args) {
        String phone_number = "01033334444";
        String answer = "";

        String endNumber = phone_number.substring(phone_number.length() - 4, phone_number.length());

        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer += "*";
        }
        answer += endNumber;


        System.out.println(answer);
//        return answer;
    }
}
