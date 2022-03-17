package programmers;

public class p17681 {
    private static int row;

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        // 시작
        row = arr1.length;

        String[] answer = new String[row];
        for (int i = 0; i < row; i++) {
            String line1 = Integer.toBinaryString(arr1[i]);
            String line2 = Integer.toBinaryString(arr2[i]);

            line1 = make5string(line1);
            line2 = make5string(line2);

            String temp = "";

            for (int j = 0; j < row; j++) {
                if (line1.charAt(j) == '1' || line2.charAt(j) == '1') {
                    temp += "#";
                    continue;
                }
                temp += " ";
            }

            answer[i] = temp;
        }

        for (int i = 0; i < row; i++) {
            System.out.println(answer[i]);
        }

//        return answer;
    }

    private static String make5string(String line) {
        if (line.length() != row) {
            String temp = "";
            for (int j = 0; j < row- line.length(); j++) {
                temp += '0';
            }
            return temp + line;
        }
        return line;
    }
}
