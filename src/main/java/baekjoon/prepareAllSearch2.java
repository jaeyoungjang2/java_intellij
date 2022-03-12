import java.util.HashSet;
import java.util.Set;

public class prepareAllSearch2 {
    private static Character[] info;
    private static int numbersLength;
    private static boolean[] visit;
    private static Set<Integer> resultSet = new HashSet<>();

    public static void main(String[] args) {
        String numbers = "011";
//        String numbers = "17";

        numbersLength = numbers.length();
        info = new Character[numbersLength];
        visit = new boolean[numbersLength];

        for (int i = 0; i < numbersLength; i++) {
            info[i] = numbers.charAt(i);
        }

        for (int i = 1; i < numbersLength + 1; i++) {
            permutation(0, "", i);
        }

        int answer = 0;
        for (Integer num: resultSet) {
            if (num <= 1) {
                continue;
            }
            if (isPrime(num)) {
                answer++;
            }
        }
        System.out.println(answer);

    }

    private static void permutation(int index, String temp, int end) {
        if (index == end) {
            resultSet.add(Integer.parseInt(temp));
            return;
        }

        for (int i = 0; i < numbersLength; i++) {
            if (!visit[i]) {
                visit[i] = true;
                temp += info[i];
                permutation(index + 1, temp, end);
                visit[i] = false;

                temp = temp.substring(0, temp.length() - 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        boolean isPrime = true;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
