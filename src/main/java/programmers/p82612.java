package programmers;

public class p82612 {

    public static void main(String[] args) {
        long answer = 0;
        int price = 3;
        int money = 20;
        int count = 4;

        long lastPrice = price * count;

        long totalPrice = (price + lastPrice) * count / 2;

        answer = (totalPrice > money) ? totalPrice - money : 0;
//        return answer;
    }
}
