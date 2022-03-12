import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon15658 {
    private static int n;
    private static int[] info;
    private static String[] operatorInfo;
    private static int[] operatorCount;
    private static String[] operatorOrder = {"+", "-", "*", "/"};
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        info = new int[n];
        operatorInfo = new String[n - 1];
        operatorCount = new int[4];

        setNumber();
        setOperator();

        makeOperatorCombination(0);
        printResult();
    }

    private static void printResult() {
        Collections.sort(resultList);
        System.out.println(resultList.get(resultList.size() - 1));
        System.out.println(resultList.get(0));
    }

    private static void makeOperatorCombination(int index) {
        // 필요한 연산자의 개수는 n - 1 개
        // operator 리스트에서 n - 1 개의 조합을 모두 구해본다.
        if (index == n - 1) {
            // resultList에 연산 결과값을 저장한다.
            calculateResult();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operatorCount[i] - 1 < 0) {
                continue;
            }
            operatorCount[i] = operatorCount[i] - 1;
            operatorInfo[index] = operatorOrder[i];
            makeOperatorCombination(index + 1);
            operatorCount[i] = operatorCount[i] + 1;
            }
        }

    private static void calculateResult() {
        int sum = info[0];
        for (int i = 0; i < operatorInfo.length; i++) {
            if (operatorInfo[i].equals("+")) {
                sum += info[i + 1];
            } else if (operatorInfo[i].equals("-")) {
                sum -= info[i + 1];
            } else if (operatorInfo[i].equals("*")) {
                sum *= info[i + 1];
            } else if (operatorInfo[i].equals("/")) {
                sum /= info[i + 1];
            }
        }
        resultList.add(sum);
    }

    private static void setNumber() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void setOperator() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int num = Integer.parseInt(st.nextToken());
            operatorCount[i] = num;
        }
    }
}
