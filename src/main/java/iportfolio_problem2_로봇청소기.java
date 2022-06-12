public class iportfolio_problem2_로봇청소기 {

    public static void main(String[] args) {
//        int[][] office = {{5, -1, 4}, {6, 3, -1}, {2, -1, 1}};
//        int[][] office = {{5, 0, 4}, {6, 3, 0}, {2, 0, 1}};
        int[][] office = {{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
        int r = 1;
        int c = 0;
//        String[] move = {"go", "go", "left", "go", "left", "go", "go", "go"};
//        String[] move = {"go", "go", "right","go","go","go","go","right","go","go","go"};
        String[] move = {"go", "go", "left","go","go","go","go","left","go","go","go","go","left","go","go","go"};
//        String[] move = {"left", "right", "left", "right"};


        // 초기 자리 정리
        int answer = office[r][c];
        office[r][c] = 0;
        // 방향을 어떻게 돌릴까
        // 방향은 좌, 우로 이동함
        // 우로 이동하면 direction + 1;
        // 범위가 4이상이면? 나머지로 확인
        // 좌로 이동하면 direction - 1;
        // 범위가 0 미만이면? 4를 더하고 나머지로 확인
        // 좌로 이동하던, 우로 이동하던 4를 더하고 나머지로 확인하면 된다.

        int[] rowTemp = {-1, 0, 1, 0};
        int[] colTemp = {0, 1, 0, -1};
        // 북쪽이 처음 보고 있는 방향
        // String[] directions = {"N", "E", "S", "W"};
        int currentDirection = 0;
        // 북쪽을 바라보고 시작
        for (String s : move) {
            if (s.equals("right")) {
                currentDirection ++;
            }
            if (s.equals("left")) {
                currentDirection --;
            }

            currentDirection = (currentDirection + 4) % 4;
            if (s.equals("go")) {
                int nextR = r + rowTemp[currentDirection];
                int nextC = c + colTemp[currentDirection];
                if (nextR < 0) {
                    nextR = r;
                }
                if (nextC < 0) {
                    nextC = c;
                }
                if (nextR >= office.length) {
                    nextR = r;
                }
                if (nextC >= office.length) {
                    nextC = c;
                }

                if (office[nextR][nextC] != -1) {
                    answer += office[nextR][nextC];
                    office[nextR][nextC] = 0;
                    r = nextR;
                    c = nextC;
                }
            }
        }

//        return answer;
    }
}
