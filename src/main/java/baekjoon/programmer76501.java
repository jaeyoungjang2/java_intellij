public class programmer76501 {

    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            int absolute = absolutes[i];
            if (!signs[i]) {
                answer -= absolute;
            } else {
                answer += absolute;
            }
        }


        System.out.println(answer);
//        return answer;
    }
}
