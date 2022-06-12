public class p42883 {
    private static String answer = "";

    public static void main(String[] args) {
        String number = "1924";
        int k = 2;

        // 1. 0 번째 수 부터 length - k 번째 수에서 에서 가장 높은 수를 찾는다.
        // 2. 첫번째 찾은 번째 수 부터 length - k + 1 번째 수까지 가장 높은 수를 찾는다.

        findMaxNumber(number, -1, k, "", 0);
        System.out.println(answer);
    }

    private static void findMaxNumber(String number, int index, int k, String result, int turn) {
        int maxIndex = 0;
        int max = 0;
        if (result.length() == number.length() - k) {
            answer = result;
            return;
        }

        for (int i = index + 1; i <= k + turn; i++) {
            int num = Character.getNumericValue(number.charAt(i));
            if (num > max) {
                max = num;
                maxIndex = i;
            }
        }
        result += max;
        findMaxNumber(number, maxIndex, k, result, turn + 1);
    }
}
