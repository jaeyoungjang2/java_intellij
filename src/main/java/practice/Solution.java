import javax.swing.Spring;

public class Solution {
    private static final int INIT_TIME = 29;
    private static final int BASE_STUDY_TIME = 21;

    public static void main(String[] args) {

        int totalStudyTime = 0;
        int[] checkin = {9, 9, 9, 9, 7, 9, 8};
        int[] checkout = {23, 23, 30, 28, 30, 23, 23};
        System.out.println(solution(checkin, checkout));
    }

    public static int solution(int[] checkin, int[] checkout) {
        int totalStudyTime = 0;
        for (int i = 0; i < checkin.length; i++) {
            int startStudy = checkin[i];
            int endStudy = checkout[i];

            // 새벽 5시를 넘어가면 checkout 시간을 오후 21시로 변경
            if (endStudy >= INIT_TIME) {
                endStudy = BASE_STUDY_TIME;
            }

            int studyTime = endStudy - startStudy;
            totalStudyTime += studyTime;
        }
        return totalStudyTime;
    }
}