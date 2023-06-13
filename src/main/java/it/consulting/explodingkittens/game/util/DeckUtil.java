package it.consulting.explodingkittens.game.util;

public class DeckUtil {

    public static int setExplodingKittensQty(int numberOfPlayers) {
        return numberOfPlayers - 1;
    }

    public static int setDefuseQty(int numberOfPlayers) {
        return 6 - numberOfPlayers;
    }

}
