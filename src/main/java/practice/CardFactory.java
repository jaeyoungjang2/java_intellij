package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardFactory {

    private static List<Card> cards = new ArrayList<>();

    public static List<Card> create() {
        for (Symbol symbol : Symbol.values()) {
            for (Type type : Type.values()) {
                cards.add(new Card(symbol, type));
            }
        }
        return Collections.unmodifiableList(cards);
    }
}
