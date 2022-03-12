import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class prepareHeap1 {

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 6;
//        int[] scoville = {1, 1, 5};
//        int K = 7;

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for (int number : scoville) {
            pq.add(number);
//            System.out.println(pq.peek());
        }
//        System.out.println(pq.peek());
        heap1(pq, 1, K);
        System.out.println("HI");
        System.out.println(1);

    }

    private static void heap1(PriorityQueue<Integer> pq, int count, int k) {
        if (pq.size() < 2 && pq.peek() < k) {
            System.out.println("HHH");
            System.exit(0);
        }
        int first = pq.poll();
        int second = pq.poll();

        int sum = first + second * 2;
        pq.add(sum);
        if (sum >= k) {
            System.out.println("HHH");
            System.exit(0);
        }

        heap1(pq, count + 1, k);
    }
}


