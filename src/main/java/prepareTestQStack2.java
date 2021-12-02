import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class prepareTestQStack2 {

    public static void main(String[] args) {
//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        List<Integer> sortPriorities = new ArrayList();

        Queue<Position1> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Position1(priorities[i], i));
            sortPriorities.add(priorities[i]);
        }
        Collections.sort(sortPriorities, Collections.reverseOrder());

        int answer = 0;
        int topRankiIndex = 0;
        int rank = 1;
        while (!queue.isEmpty()) {
            // 가장 큰 값부터 찾아야 함
            // 가장 큰 값 부터 index 순서를 다시 매겨야 함

            int currentTopRank = sortPriorities.get(topRankiIndex);
            Position1 position1 = queue.remove();
            int number = position1.number;
            int index = position1.index;

            // 가장 큰 값 index를 찾았다면, 내가 원하는 location에 있는 값이 있는지를 확인
            // 내가 원하는 location에 있는 값이 맞다면 종료
            // 아니라면 다음 topRank 값을 찾아야 함
            if (number == currentTopRank) {
                if (index == location) {
                    answer = rank;
                    break;
                }
                topRankiIndex++;
                rank++;
                continue;
            }
            queue.add(new Position1(number, index));
        }
        System.out.println(answer);
    }
}

class Position1 {
    int number;
    int index;
    public Position1(int number, int index) {
        this.number = number;
        this.index = index;
    }
}
