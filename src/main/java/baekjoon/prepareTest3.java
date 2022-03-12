import java.util.*;

public class prepareTest3 {


    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Map<String, Integer> map = new HashMap<>();
        for (String[] cloth: clothes) {
            String clothType = cloth[1];
            map.put(clothType, map.getOrDefault(clothType, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (String clothType: map.keySet()) {
            list.add(map.get(clothType));
        }

        int answer = list.stream().reduce(1, (a, b) -> a * (b + 1)) - 1;
    }
}
