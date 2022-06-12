import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class P6084 {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        String answer = "";
        int[][] position = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2},
        };


        List<Integer> checkList = new ArrayList<>(Arrays.asList(2, 5, 8, 0));
        List<Integer> leftCheckList = new ArrayList<>(Arrays.asList(1, 4, 7));
        List<Integer> rightCheckList = new ArrayList<>(Arrays.asList(3, 6, 9));
        Position left = new Position(3, 0);
        Position right = new Position(3, 2);

        for (int number : numbers) {
            int[] positions = position[number];
            int numberRow = positions[0];
            int numberCol = positions[1];
            int leftDistance = Math.abs((left.getRow() - numberRow) + Math.abs(left.getCol() - numberCol));
            int rightDistance = Math.abs((right.getRow() - numberRow)) + Math.abs(right.getCol() - numberCol);

            System.out.println("number = " + number);
            System.out.println("leftDistance = " + leftDistance);
            System.out.println(left.getRow());
            System.out.println(left.getCol());
            System.out.println("rightDistance = " + rightDistance);
            System.out.println(right.getRow());
            System.out.println(right.getCol());

            // 중립
            if (checkList.contains(number)) {
                System.out.println("contains");
                if (leftDistance == rightDistance) {
                    if (hand.equals("right")) {
                        answer = move(answer, right, numberRow, numberCol, "R");
                        continue;
                    }
                    answer = move(answer, left, numberRow, numberCol, "L");
                    continue;
                }

                if (leftDistance < rightDistance) {
                    answer = move(answer, left, numberRow, numberCol, "L");
                    continue;
                }
                answer = move(answer, right, numberRow, numberCol, "R");
                continue;
            }

            // 왼쪽
            if (leftCheckList.contains(number)) {
                System.out.println("leftContains");
                answer = move(answer, left, numberRow, numberCol, "L");
                continue;
            }
            System.out.println("rightContains");
            answer = move(answer, right, numberRow, numberCol, "R");
            continue;
        }
        System.out.println(answer);

    }

    private static String move(String answer, Position hand, int numberRow, int numberCol,
        String movingHand) {
        answer += movingHand;
        hand.setRow(numberRow);
        hand.setCol(numberCol);
        return answer;
    }

}

class Position {

    private int row = 0;
    private int col = 0;

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}