package baekjoon;

public class prepareBfsDfs2 {
    private static boolean[] visit;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int answer = 0;

        visit = new boolean[computers.length];
        for (int i = 0; i < computers.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                answer++;
                bfsdfs2(i, computers);
            }
        }
        System.out.println(answer);
    }

    private static void bfsdfs2(int currentComputer, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            if (computers[currentComputer][i] == 1 && !visit[i]) {
                visit[i] = true;
                bfsdfs2(i, computers);
            }
        }
    }
}
