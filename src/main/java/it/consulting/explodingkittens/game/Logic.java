package it.consulting.explodingkittens.game;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.card.action.FavorCard;
import it.consulting.explodingkittens.card.action.SeeTheFutureCard;
import it.consulting.explodingkittens.card.action.ShuffleCard;
import it.consulting.explodingkittens.card.special.DefuseCard;
import it.consulting.explodingkittens.card.special.ExplodingKittenCard;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Logic {
    private List<Card> deckCards;
    private List<Card> playerCards;
    private List<Player> players;


    public void turn(int playerNumber, int playerToAttack, Card card) {
        if (card instanceof SeeTheFutureCard) {
            System.out.println(deckCards.get(0) + ", " + deckCards.get(1) + ", " + deckCards.get(2));
        } else if (card instanceof ShuffleCard) {
            Collections.shuffle(deckCards);
        } else if (card instanceof ExplodingKittenCard) {
            if (playerCards.stream().anyMatch(c -> c instanceof DefuseCard)) {
                Card defuse = playerCards.stream().filter(c -> c instanceof DefuseCard).findFirst().orElseThrow();
                playerCards.remove(defuse);
            }
        }
    }

    private List<Card> getPlayerCards(int playerNumber) {
        return players.get(playerNumber-1).getCards();
    }
}
