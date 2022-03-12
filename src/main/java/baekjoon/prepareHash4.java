import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class prepareHash4 {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        // 장르 - 플레이 수
        Map<String, Integer> map = new HashMap<>();
        // 장르 - 곡의 수 (answer 개수를 지정하기 위함)
        Map<String, Integer> genreCount = new HashMap<>();
        // 장르 + 플레이 수 - 고유 번호
        Map<String, List<Integer>> generePlayMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            map.put(genre, map.getOrDefault(genre, 0) + play);
            genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
            generePlayMap.put(genre+play, generePlayMap.getOrDefault(genre+play, new ArrayList<>()));
            generePlayMap.get(genre+play).add(i);
        }

        int answerCount = 0;
        for (int value: genreCount.values()) {
            if (value >= 2) {
                answerCount += 2;
                continue;
            }
            answerCount += value;
        }
        int[] answer = new int[answerCount];


        ArrayList<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

        int index = 0;
        for (Entry<String, Integer> entry: entries) {
            String topGenre = entry.getKey();
            int genreSize = 0;
            boolean run = true;

            Set<Integer> genrePlaysSet= new HashSet<>();
            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int play = plays[i];
                if (genre.equals(topGenre)) {
                    genrePlaysSet.add(play);
                }
            }
            ArrayList<Integer> genrePlaysList = new ArrayList<>(genrePlaysSet);
            Collections.sort(genrePlaysList, Collections.reverseOrder());

            for (int play: genrePlaysList) {
                if (!run) {
                    break;
                }
                for (int initialNum: generePlayMap.get(topGenre+play)) {
                    answer[index] = initialNum;
                    index++;
                    genreSize++;
                    if (genreSize == 2) {
                        run = false;
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
