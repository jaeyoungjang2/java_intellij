import java.util.ArrayList;
import java.util.List;

public class P67257 {

    public static void main(String[] args) {
        long answer = 0;
//        String expression = 100 - 200 * 300 - 500 + 20;
//         * 앞 뒤의 수를 최대화
        String expression = "1+2+3";

        String[] list = {"+-*", "+*-", "-+*", "-*+", "*+-", "*-+"};
        String sample = "+-*";

        List<Long> numberList = new ArrayList<>();
        List<String> operatorList = new ArrayList<>();
        String temp = "";

        for (int i = 0; i < expression.length(); i++) {
            String s = String.valueOf(expression.charAt(i));
            if (sample.contains(s)) {
                operatorList.add(s);
                numberList.add(Long.valueOf(temp));
                temp = "";
                continue;
            }
            temp += s;
        }
        numberList.add(Long.valueOf(temp));


        Long max = 0L;
        for (String s : list) {
            List<Long> numberListCopy = new ArrayList<>();
            List<String> operatorListCopy = new ArrayList<>();
            numberListCopy.addAll(numberList);
            operatorListCopy.addAll(operatorList);
            for (int i = 0; i < s.length(); i++) {

                char targetOperator = s.charAt(i);

                while (true) {
                    if (!operatorListCopy.contains(String.valueOf(targetOperator))) {
                        break;
                    }
                    int index = operatorListCopy.indexOf(String.valueOf(targetOperator));
                    Long i1 = numberListCopy.get(index);
                    Long i2 = numberListCopy.get(index + 1);
                    operatorListCopy.remove(index);
                    numberListCopy.remove(index);
                    numberListCopy.set(index, cal(i1, i2, targetOperator)) ;
                }
            }
            if (max < Math.abs(numberListCopy.get(0))) {
                max = Math.abs(numberListCopy.get(0));
            }
        }

        System.out.println("max = " + max);
    }

    private static Long cal(Long i1, Long i2, char targetOperator) {
        if (targetOperator == '+') {
            return i1 + i2;
        }
        if (targetOperator == '-') {
            return i1 - i2;
        }
        return i1 * i2;
    }
}
