package baekjoon;

import java.util.Arrays;
import java.util.Collections;

public class prepareSort3 {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
//        int[] citations = {350, 452, 877};
        Arrays.sort(citations);

        int answer = 0;
        int numOfPaper = citations.length;
        for (int i = 0; i <= numOfPaper; i++) {
            int numOfCitation = citations[i];
            if (numOfCitation >= numOfPaper) {
                answer = numOfPaper ;
                break;
            }
            numOfPaper--;
        }
        System.out.println(answer);
    }
}
