import java.util.*;


public class prepareTest {

    public static void main(String[] args) {
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            int row = v[i][0];
            int col = v[i][1];
            mapX.put(row, 0);
            mapY.put(col, 0);
        }

        for (int i = 0; i < v.length; i++) {
            int row = v[i][0];
            int col = v[i][1];
            mapX.put(row, mapX.get(row) + 1);
            mapY.put(col, mapY.get(col) + 1);
        }

        int resultRow = 0;
        int resultCol = 0;

        for (int i = 0; i < v.length; i++) {
            int row = v[i][0];
            int col = v[i][1];
            if (mapX.get(row) == 1) {
                resultRow = row;
            }
            if (mapY.get(col) == 1) {
                resultCol = col;
            }
        }
        int[] answer = {resultRow, resultCol};
    }
}
