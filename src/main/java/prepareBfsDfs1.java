import java.util.Arrays;

public class prepareBfsDfs1 {
    private static String[] operator = {"+", "-"};
    private static String[] info;
    private static int count = 0;

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = 0;
        info = new String[numbers.length];

        dfsNumberCombination(0, numbers, target);
        answer = count;
        System.out.println(answer);
    }

    private static void dfsNumberCombination(int index, int[] numbers, int target) {
        if (index == info.length) {
            int tempSum = 0;
            for (int i = 0; i < info.length; i++) {
                if (info[i].equals("+")) {
                    tempSum += numbers[i];
                } else if (info[i].equals("-")) {
                    tempSum -= numbers[i];
                }
            }
            if (tempSum == target) {
                count++;
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            info[index] = operator[i];
            dfsNumberCombination(index + 1, numbers, target);
        }
    }
}
