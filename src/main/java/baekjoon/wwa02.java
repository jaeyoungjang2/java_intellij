import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class wwa02 {

    public static void main(String[] args) throws ParseException {
        String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
//        String[] log = {"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"};
        SimpleDateFormat f = new SimpleDateFormat("HH:mm");

        long studyTime = 0;
        for (int i = 0; i < log.length; i+=2) {
            Date start = f.parse(log[i]);
            Date stop = f.parse(log[i + 1]);
            long diff = stop.getTime() - start.getTime();
            long min = diff /  (60 * 1000);
            if (min < 5) {
                continue;
            }
            if (min >= 105) {
                studyTime += 105;
                continue;
            }
            studyTime += min;
        }

        long resultH = studyTime / 60;
        long resultM = studyTime % 60;

        String resultHours = Long.toString(resultH);
        String resultMinutes = Long.toString(resultM);
        if (resultH < 10) {
            resultHours = "0" + resultH;
        }
        if (resultM < 10) {
            resultMinutes = "0" + resultM;
        }
        String answer = resultHours + ":" + resultMinutes;
        System.out.println(resultM);
    }
}
