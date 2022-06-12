import java.util.ArrayList;
import java.util.List;

public class B12906_같은숫자는싫어 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};



        int before = arr[0];
        List<Integer> list = new ArrayList<>();
        list.add(before);
        for (int i = 1; i < arr.length; i++) {
            if (before != arr[i]) {
                list.add(arr[i]);
                before = arr[i];
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
//        return answer;
    }
}
