import java.util.Stack;

public class Permutation {
    private static boolean[] visit;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        visit = new boolean[arr.length];
        Stack<Integer> stack = new Stack<>();
        permutation(stack, arr);
    }

    private static void permutation(Stack<Integer> stack, int[] arr) {
        if (stack.size() == 3) {
            System.out.println(stack);
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visit[i]) {
                stack.add(arr[i]);
                visit[i] = true;
                permutation(stack, arr);
                visit[i] = false;
                stack.pop();
            }
        }
    }
}
