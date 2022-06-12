package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Card> tempCards = CardFactory.create();
        List<Card> cards = new ArrayList<>();
        for (Card card : tempCards) {
            cards.add(card);
        }

        Collections.shuffle(cards);
        Card card = cards.get(0);
        System.out.println(card.toString());
    }
}
