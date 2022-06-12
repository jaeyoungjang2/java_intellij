import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B42746_가장큰수 {
    private static List<Integer> list = new ArrayList<>();
    private static boolean[] visit;

    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        for (int number : numbers) {

        }
        
        Collections.sort(list);
        System.out.println(String.valueOf(list.get(list.size() - 1)));
        System.out.println(list);
    }

   
}
