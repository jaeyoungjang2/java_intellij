import java.util.Locale;

public class pp12930 {

    public static void main(String[] args) {
        String s = "try hello world";
        String[] s1 = s.split("");

        String answer = "";
        int count = 0;
        for (String s2 : s1) {
            count = s2.contains(" ") ? 0 : count + 1;
            answer = count % 2 == 0 ? answer + s2.toUpperCase()
                : answer + s2.toLowerCase();
        }
        System.out.println(answer);
    }
}
