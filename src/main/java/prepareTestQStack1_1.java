import java.util.Arrays;

public class prepareTestQStack1_1 {

    public static void main(String[] args) {
        int[] progresses = {99, 1, 99, 1};
        int[] speeds = {1, 1, 1, 1};

        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        System.out.println(Arrays.toString(dayOfend));
        int[] ints = Arrays.stream(dayOfend).filter(i -> i != 0).toArray();
        System.out.println(Arrays.toString(ints));
    }
}
