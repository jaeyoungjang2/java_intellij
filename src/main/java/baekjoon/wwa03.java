package baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class wwa03 {

    public static void main(String[] args) {
//        String[] ings = {"r 10", "a 23", "t 124", "k 9"};
//        String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
//        String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        String[] ings = {"x 25", "y 20", "z 1000"};
        String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
        String[] sell = {"BBBB 3", "TTT 2"};
        int answer = 0;

        // 원재료 가격 정리
        Map<String, Integer> materialCostMap = new HashMap<>();
        for (String materialCost : ings) {
            StringTokenizer st = new StringTokenizer(materialCost);
            String material = st.nextToken();
            Integer cost = Integer.parseInt(st.nextToken());
            materialCostMap.put(material, cost);
        }

        // 메뉴 별 순이익 정리
        Map<String, Integer> menuProfitMap = new HashMap<>();
        for (String menuMaterialsPrice : menu) {
            StringTokenizer st = new StringTokenizer(menuMaterialsPrice);
            String storeMenu = st.nextToken();
            String materials = st.nextToken();
            Integer price = Integer.parseInt(st.nextToken());
            Integer materialsCost = 0;
            for (int i = 0; i < materials.length(); i++) {
                String material = Character.toString(materials.charAt(i));
                materialsCost += materialCostMap.get(material);
            }
            menuProfitMap.put(storeMenu, price - materialsCost);
        }

        // 금일 순이익 정리
        for (String storeMenuSellCount : sell) {
            StringTokenizer st = new StringTokenizer(storeMenuSellCount);
            String storeMenu = st.nextToken();
            Integer sellCount = Integer.parseInt(st.nextToken());
            Integer todayProfit = menuProfitMap.get(storeMenu) * sellCount;
            answer += todayProfit;
        }

        System.out.println(answer);
    }


}
