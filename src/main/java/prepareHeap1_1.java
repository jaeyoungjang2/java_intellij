import java.util.PriorityQueue;

public class prepareHeap1_1 {

    public static void main(String[] args) {
        int[] scoville = {0, 0, 1, 2, 3, 9, 10, 12};
        int K = 6;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < scoville.length; i++)
            q.add(scoville[i]);

        int answer = 0;
        while(true){
            int weakHot = q.poll();
            int secondWeakHot = q.poll();

            int mixHot = weakHot + (secondWeakHot * 2);
            if (q.size() <= 1 || q.peek() >= K) {
                break;
            }
            q.add(mixHot);
            answer++;
            if(q.size() <= 1 && q.peek() < K) {
                answer = -1;
                break;
            }
        }
    }
}
