package baekjoon;

import java.util.LinkedList;
import java.util.Queue;

public class prepareTesteQStack3 {

    public static void main(String[] args) {
        int bridge_length = 5;
        int weight = 5;
        int[] truck_weights = {2, 2, 2, 2, 1, 1, 1, 1, 1};

        int answer = 0;

        int carIndex = 0;
        int time = 1;
        Queue<Integer> endTimeQueue = new LinkedList<>();
        endTimeQueue.add(time + bridge_length);
        int bridge_weight = truck_weights[carIndex];
        time ++;
        carIndex ++;
        int firstCarInBridge = 0;

        while (!endTimeQueue.isEmpty()) {
            System.out.println(bridge_weight);
            System.out.println(endTimeQueue);
            System.out.println();
            if (carIndex == truck_weights.length) {
                answer = endTimeQueue.remove();
                continue;
            }
            if (weight >= bridge_weight + truck_weights[carIndex]) {
                bridge_weight += truck_weights[carIndex];
                endTimeQueue.add(time + bridge_length);
                carIndex ++;
                time++;
            } else {
                time = Math.max(endTimeQueue.remove(), time);
                bridge_weight -= truck_weights[firstCarInBridge];
                firstCarInBridge++;
                if (weight >= bridge_weight + truck_weights[carIndex]) {
                    bridge_weight += truck_weights[carIndex];
                    endTimeQueue.add(time + bridge_length);
                    carIndex++;
                    time++;
                }
            }

        }
        System.out.println("answer");
        System.out.println(answer);
    }
}
