package it.consulting.explodingkittens.game.util;

import it.consulting.explodingkittens.card.Card;

import java.util.List;

public class DeckUtil {

    public static int setExplodingKittensQty(int numberOfPlayers) {
        return numberOfPlayers - 1;
    }

    public static int setDefuseQty(int numberOfPlayers) {
        return 6 - numberOfPlayers;
    }

    public static List<Card> addCardsToDeck(List<Card> cards, int numberOfCards, Card cardType) {
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(cardType);
        }
        return cards;
    }



}
