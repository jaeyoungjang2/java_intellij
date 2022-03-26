package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class p77484 {

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        Map<Integer, Integer> rank = new HashMap<>();
        rank.put(6, 1);
        rank.put(5, 2);
        rank.put(4, 3);
        rank.put(3, 4);
        rank.put(2, 5);
        rank.put(1, 6);
        rank.put(0, 6);


        List<Integer> lottoList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        // 로또와 당첨번호의 교집합
        Set<Integer> intersect = new HashSet<>();
        // 당첩번호 중에서 로또 번호만 제거
        Set<Integer> difference = new HashSet<>();

        intersect.addAll(lottoList);
        difference.addAll(winList);

        intersect.retainAll(difference);
        difference.removeAll(intersect);

        int minRank = rank.get(intersect.size());

        int zeroNum = Long.valueOf(Math.max(lottoList.stream().filter(num -> num == 0).count(), 0))
            .intValue();
        int maxRank = rank.get(intersect.size() + zeroNum);

        int[] answer = {minRank, maxRank};
    }
}
