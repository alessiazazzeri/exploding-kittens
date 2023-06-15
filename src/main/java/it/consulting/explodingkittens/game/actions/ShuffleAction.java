package it.consulting.explodingkittens.game.actions;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.game.Deck;

import java.util.Collections;
import java.util.List;

public class ShuffleAction extends CardAction {
    @Override
    public void execute() {
        List<Card> deckCards = super.getDeckCards();
        Collections.shuffle(deckCards);
        super.setDeckCards(deckCards);
    }

}
