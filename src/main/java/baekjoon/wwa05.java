package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class wwa05 {

    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;

        int[][] answer = new int[rows][columns];

        int numOfZero = rows * columns;
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 1));
        while (true) {
            if (numOfZero == 0) {
                break;
            }

            Position position = queue.remove();
            int currentRow = position.row;
            int currentCol = position.col;
            int currentNumber = position.number;

            if (answer[currentRow][currentCol] == 0) {
                numOfZero--;
            } else if ((answer[currentRow][currentCol] % 2 == 0 && currentNumber % 2 == 0) || (answer[currentRow][currentCol] % 2 == 1 && currentNumber % 2 == 1)) {
                break;
            }
            System.out.println("HI");
            answer[currentRow][currentCol] = currentNumber;

            Position nextPostiion = position.calculateNext(rows, columns);
            queue.add(nextPostiion);
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.println(Arrays.toString(answer[i]));
        }
    }
}

class Position {
    int row;
    int col;
    int number;

    public Position(int row, int col, int number) {
        this.row = row;
        this.col = col;
        this.number = number;
    }

    public Position calculateNext(int rows, int columns) {
        int nextRow = row;
        int nextCol = col;
        int nextNumber = number + 1;
        // 짝수 - 칼럼 한칸 아래로 전진
        if (number % 2 == 0) {
            nextRow = row + 1;
            if (nextRow >= rows) {
                nextRow = 0;
            }

        }
        // 홀수 - 로우 한칸 오른쪽으로 이동
        if (number % 2 == 1) {
            nextCol = col + 1;
            if (nextCol >= columns) {
                nextCol = 0;
            }
        }
        return new Position(nextRow, nextCol, nextNumber);
    }
}