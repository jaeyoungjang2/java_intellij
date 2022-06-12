import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class P17683 {

    public static void main(String[] args) throws ParseException {
//        String m = "ABCDEFG";
//        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

//        String m = "CC#BCC#BCC#BCC#B";
//        String[] musicinfos = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};

//        String m = "ABC";
//        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String m = "CC#BCC#BCC#";
        String[] musicinfos = {"03:00,03:08,FOO,CC#B"};

        String answer = "(None)";
        Integer musicTime = 0;

        m = m.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");

        for (String musicinfo : musicinfos) {
            String[] split = musicinfo.split(",");
            SimpleDateFormat f = new SimpleDateFormat("HH:mm");
            long diff = f.parse(split[1]).getTime() - f.parse(split[0]).getTime();
//            int minutes = (int) diff / 60000;

            String[] ST = split[0].split(":");
            String[] ET = split[1].split(":");
            int minutes = Integer.parseInt(ET[0])*60+Integer.parseInt(ET[1]) -Integer.parseInt(ST[0])*60+Integer.parseInt(ST[1]);

            String song = split[2];
            String music = split[3];
            music = music.replace("C#", "c").replace("D#", "d").replace("F#", "f").replace("G#", "g").replace("A#", "a");


            String total_music = music;
            // 같은 음이 시작하는 지점 저장
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < music.length(); i++) {
                if (music.charAt(i) == m.charAt(0)) {
                    list.add(i);
                }
            }

            // 음의 길이를 저장하고
            while (total_music.length() < minutes) {
                total_music += music;
            }
            total_music = total_music.substring(0, minutes);

            for (Integer integer : list) {
                if (integer + m.length() > minutes) {
                    continue;
                }

                if (total_music.substring(integer, integer + m.length()).equals(m)) {
                    if (musicTime < minutes) {
                        answer = song;
                        musicTime = minutes;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
