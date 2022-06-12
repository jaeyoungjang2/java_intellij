package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon14889 {
    private static int n;
    private static boolean[] visit;
    private static int[] teamAInfo;
    private static int[] teamBInfo;
    private static int[][] info;
    private static List<Integer> resultList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new int[n][n];
        visit = new boolean[n];
        teamAInfo = new int[n / 2];
        teamBInfo = new int[n / 2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectAteam(0, 0);
        Collections.sort(resultList);
        System.out.println(resultList.get(0));
    }
    private static void calculateTeamScore() {
        int teamAscore = 0;
        int teamBscore = 0;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                if (i != j) {
                    teamAscore += info[teamAInfo[i]][teamAInfo[j]];
                    teamBscore += info[teamBInfo[i]][teamBInfo[j]];
                }
            }
        }
        resultList.add(Math.abs(teamAscore - teamBscore));

    }

    private static void selectBteam() {
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                teamBInfo[index] = i;
                index ++;
            }
        }
        calculateTeamScore();
    }

    private static void selectAteam(int index, int start) {
        if (index == n / 2) {
            selectBteam();
            return;
        }
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                teamAInfo[index] = i;
                selectAteam(index + 1, i + 1);
                visit[i] = false;
            }
        }
    }
}
