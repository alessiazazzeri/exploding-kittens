package it.consulting.explodingkittens.game.actions;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.game.Deck;

import java.util.List;

public class SeeTheFutureAction extends CardAction {
    @Override
    public void execute() {
        List<Card> deckCards = super.getDeckCards();
        System.out.println(deckCards.get(0) + ", " + deckCards.get(1) + ", " + deckCards.get(2));
    }

}
