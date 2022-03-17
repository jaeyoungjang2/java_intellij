package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p67256 {

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        List<List<Integer>> phoneDistance = new ArrayList<>();
        phoneDistance.add(new ArrayList<>(Arrays.asList(0, 4, 3, 4, 3, 2, 3, 2, 1, 2)));
        // 1
        phoneDistance.add(new ArrayList<>(Arrays.asList(4, 0, 1, 2, 1, 2, 3, 2, 3, 4)));
        // 2
        phoneDistance.add(new ArrayList<>(Arrays.asList(3, 1, 0, 1, 2, 1, 2, 3, 2, 3)));
        // 3
        phoneDistance.add(new ArrayList<>(Arrays.asList(4, 0, 1, 2, 1, 2, 3, 2, 3, 4)));
        // 4
        phoneDistance.add(new ArrayList<>(Arrays.asList(3, 1, 2, 3, 0, 1, 2, 1, 2, 3)));
        // 5
        phoneDistance.add(new ArrayList<>(Arrays.asList(2, 2, 1, 2, 1, 0, 1, 2, 1, 2)));
        // 6
        phoneDistance.add(new ArrayList<>(Arrays.asList(3, 3, 2, 1, 2, 1, 0, 3, 2, 1)));
        // 7
        phoneDistance.add(new ArrayList<>(Arrays.asList(2, 2, 3, 4, 1, 2, 3, 0, 1, 2)));
        // 8
        phoneDistance.add(new ArrayList<>(Arrays.asList(1, 3, 2, 3, 2, 1, 2, 1, 0, 1)));
        // 9
        phoneDistance.add(new ArrayList<>(Arrays.asList(2, 4, 3, 2, 3, 2, 1, 2, 1, 0)));
        // 10 (*)
        phoneDistance.add(new ArrayList<>(Arrays.asList(1, 3, 4, 5, 2, 3, 4, 1, 2, 3)));
        // 11 (#)
        phoneDistance.add(new ArrayList<>(Arrays.asList(1, 5, 4, 3, 4, 3, 2, 3, 2, 1)));

        List<Integer> leftNumbers = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> rightNumbers = new ArrayList<>(Arrays.asList(3, 6, 9));
        Map<Integer, List<Integer>> leftHandInfo = new HashMap();
        int leftHandPosition = 10;
        int rightHandPosition = 11;


        String answer = "";
        for (int i = 0; i < numbers.length; i++) {
            System.out.println();
            int targetNumber = numbers[i];
            System.out.println("targetNumber = " + targetNumber);
            if (leftNumbers.contains(targetNumber)) {
                leftHandPosition = targetNumber;
                answer += "L";
                System.out.println("leftHand1");
                continue;
            }
            if (rightNumbers.contains(targetNumber)) {
                rightHandPosition = targetNumber;
                answer += "R";
                System.out.println("rightHand1");
                continue;
            }
            int leftHandDistance = phoneDistance.get(leftHandPosition).get(targetNumber);
            System.out.println("leftHandDistance = " + leftHandDistance);
            int rightHandDistance = phoneDistance.get(rightHandPosition).get(targetNumber);
            System.out.println("rightHandDistance = " + rightHandDistance);
            if (leftHandDistance < rightHandDistance) {
                leftHandPosition = targetNumber;
                answer += "L";
                System.out.println("leftHand2");
                continue;
            }
            if (rightHandDistance < leftHandDistance) {
                rightHandPosition = targetNumber;
                answer += "R";
                System.out.println("rightHand2");
                continue;
            }
            if (hand.equals("left")) {
                leftHandPosition = targetNumber;
                answer += "L";
                System.out.println("leftHand3");
                continue;
            }
            if (hand.equals("right")) {
                rightHandPosition = targetNumber;
                answer += "R";
                System.out.println("rightHand3");
            }

        }
        System.out.println(answer);
    }
}
