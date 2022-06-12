import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int count = 1;

        // 처음 수를 왼쪽과 오른쪽으로 나눈다.
        Number beforeNumber = divideLeftRight(num);
        while (true) {

            // 위에서 왼쪽 오른쪽으로 나눈 수를 더하고, 이전 수의 오른쪽과 더한 수의 오른쪽의 수를 이용하여 새로운 수를 구한다.
            Number newNumber = makeNewNumber(beforeNumber.getRight(), beforeNumber.sum());

            if (num == newNumber.show()) {
                break;
            }

            beforeNumber = newNumber;
            count ++;
        }
        System.out.println(count);
    }

    private static Number makeNewNumber(int right, int sum) {
        if (sum < 10) {
            return new Number(right, sum);
        }

        // 10보다 크면 sum에서는 오른쪽만 들고와야 함
        sum %= 10;
        return new Number(right, sum);
    }

    private static Number divideLeftRight(int num) {
        if (num < 10) {
            return new Number(0, num);
        }

        int left = num / 10;
        num %= 10;
        int right = num;
        return new Number(left, right);
    }
}


class Number {
    private int left;
    private int right;

    public Number(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int sum() {
        return left + right;
    }

    public int show() {

        return left * 10 + right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}