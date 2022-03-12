public class programmers12969 {

    public static void main(String[] args) {
        int a = 5;
        int b = 3;
        String answer = "";
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                answer += "*";
            }
            answer += "\n";
        }
        System.out.println(answer);

    }
}
