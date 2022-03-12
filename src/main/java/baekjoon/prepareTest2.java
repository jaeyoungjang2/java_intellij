import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class prepareTest2 {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        Set<Integer> set = new HashSet<>();

        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();


        for (String phoneNumber : phone_book) {
            map.put(phoneNumber, 0);
            set.add(phoneNumber.length());
        }

        List<Integer> list = new ArrayList<>(set);
        for (String phoneNumber : phone_book) {
            if (!answer) {
                break;
            }
            int phoneNumberLength = phoneNumber.length();
            for (Integer length : list) {
                if (length != phoneNumberLength &&  length < phoneNumberLength && map.containsKey(phoneNumber.substring(0, length))) {
                    answer = false;
                    break;
                }
            }
        }
    }
}
