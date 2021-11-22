import java.util.Arrays;

public class wwa7 {

    public static void main(String[] args) {
        String[] grid = {"1", "234", "56789"};
        boolean clockwise = true;
//        String[] grid = {"A","MAN","DRINK","WATER11"};
//        boolean clockwise = false;

        String[] answer = new String[grid.length];
        int size = grid.length * 2 - 1;
        String[][] info = new String[grid.length][size];

        int middle = size / 2;
        for (int i = 0; i < grid.length; i++) {
            String temp = grid[i];
            for (int j = 0; j < temp.length(); j++) {
                info[i][middle - i + j] = Character.toString(temp.charAt(j));
            }
        }

        for (int i = 0; i < info.length; i++) {
            System.out.println(Arrays.toString(info[i]));
        }

        int index = 0;
        if (clockwise) {
            for (int i = 0; i < grid.length; i++) {
                String temp = "";
                int row = grid.length - 1;
                int col = 2 * i;
                for (int j = 0; j < 2 * i + 1; j++) {
                    temp += info[row][col];
                    if (j %2 == 0) {
                        col --;
                    } else {
                        row --;
                    }
                }
                answer[index] = temp;
                index++;
            }
        } else {
            for (int i = 0; i < grid.length; i++) {
                String temp = "";
                int row = grid.length - 1 - i;
                int col = size - 1 - i;

                System.out.println(i);
                System.out.println(row);
                System.out.println(col);
                System.out.println();

                for (int j = 0; j < 2 * i + 1; j++) {

                    temp += info[row][col];
                    if (j %2 == 0) {
                        row ++;
                    } else {
                        col --;
                    }
                }
                answer[index] = temp;
                index++;
            }

        }
        System.out.println(Arrays.toString(answer));
    }
}
