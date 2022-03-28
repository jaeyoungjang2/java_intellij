import java.util.Stack;

public class Combination {
    private static boolean[] visit;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        visit = new boolean[arr.length];
        Stack<Integer> stack = new Stack<>();
        combination(0, stack, arr);
    }

    private static void combination(int index, Stack<Integer> stack, int[] arr) {
        if (stack.size() == 3) {
            System.out.println(stack);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                stack.add(arr[i]);
                combination(i + 1, stack, arr);
                stack.pop();
                visit[i] = false;
            }
        }
    }
}
