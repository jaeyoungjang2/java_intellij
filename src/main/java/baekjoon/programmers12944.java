package baekjoon;

public class programmers12944 {

    public static void main(String[] args) {
        int[] arr = {5,5};

        double total = 0;

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        double answer = total / arr.length;
    }
}
