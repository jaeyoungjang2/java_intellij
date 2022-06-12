public class P12904_가장긴펠린드롬 {

    public static void main(String[] args) {
        String s = "aaaa";

        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            // 홀수개의 펠린드롬
            while (true) {
                if (i - count < 0 || i + count >= s.length()) {
                    break;
                }

                if (s.charAt(i - count) == s.charAt(i + count)) {
                    answer = Math.max(answer, 2 * count + 1);
                    count++;
                } else {
                    break;
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int upper = -1;
            int lower = 0;
            while (true) {
                lower ++;
                upper ++;
                if (i - lower < 0 || i + upper >= s.length()) {
                    break;
                }
                if (s.charAt(i - lower) == s.charAt(i + upper)) {
                    answer = Math.max(answer, upper + lower + 1);

                } else {
                    break;
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}
