package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon15686 {
    private static List<Location> homes;
    private static List<Location> chickens;
    private static int[][] info;
    private static int minimum_distance = 0;
    private static Location[] remain_candidate_chicken;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        // 배열의 크기 N
        // 남길 치킨집의 수 M
        // 치킨거리의 최소 값을 구하라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        remain_candidate_chicken = new Location[m];
        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        info = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int location_info = Integer.parseInt(st.nextToken());
                info[i][j] = location_info;

                if (location_info == 1) {
                    homes.add(new Location(i, j));
                }
                if (location_info == 2) {
                    chickens.add(new Location(i, j));
                }
            }
        }

        combination(0, 0);
        System.out.println(minimum_distance);
    }

    private static void combination(int index, int start) {
        if (index == remain_candidate_chicken.length) {
            calculate_minimum_chicken_distance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            remain_candidate_chicken[index] = chickens.get(i);
            combination(index + 1, i + 1);
        }
    }

    private static void calculate_minimum_chicken_distance() {
        int minimum_chicken_distance_home_and_chicken_array = 0;
        // remain_candidate_chicken 집이 최단거리 확인해봐야 하는 치킨집임
        // 여기에 있는 치킨집과, 집들 사이의 치킨 거리를 구하고
        // 치킨 거리가 최단 거리일 경우
        // final_chicken 배열에 저장하자

        // 치킨집 마다 검사
        for (int i = 0; i < homes.size(); i++) {
            Location home = homes.get(i);
            int home_row = home.getRow();
            int home_col = home.getCol();
            // 해당 치킨 집과, 집 사이의 최단 거리를 구함
            int minimum_chicken_distance_home_and_target_chicken = 0;

            // 집마다 최단 치킨 거리 검사
            for (int j = 0; j < remain_candidate_chicken.length; j++) {
                Location chicken_location = remain_candidate_chicken[j];
                int chicken_row = chicken_location.getRow();
                int chicken_col = chicken_location.getCol();

                int distance = Math.abs(chicken_row - home_row) + Math.abs(chicken_col - home_col);
                if (minimum_chicken_distance_home_and_target_chicken == 0) {
                    minimum_chicken_distance_home_and_target_chicken = distance;
                } else if (minimum_chicken_distance_home_and_target_chicken > distance) {
                    minimum_chicken_distance_home_and_target_chicken = distance;
                }
            }
            // 집 마다 검사를 완료했고, 해당 치킨집의 최단 치킨거리를 구했음
            minimum_chicken_distance_home_and_chicken_array += minimum_chicken_distance_home_and_target_chicken;
        }
        if (minimum_distance == 0) {
            minimum_distance = minimum_chicken_distance_home_and_chicken_array;
        } else if (minimum_distance > minimum_chicken_distance_home_and_chicken_array) {
            minimum_distance = minimum_chicken_distance_home_and_chicken_array;
        }


    }
}

class Location {
    private int row;
    private int col;

    public Location(int row, int col) {
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
