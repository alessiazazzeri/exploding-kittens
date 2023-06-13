package it.consulting.explodingkittens.game;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.card.action.*;
import it.consulting.explodingkittens.card.cat.*;
import it.consulting.explodingkittens.card.special.DefuseCard;
import it.consulting.explodingkittens.card.special.ExplodingKittenCard;
import it.consulting.explodingkittens.game.util.DeckUtil;

import java.util.List;

public class Deck {
    private List<Card> cards;
    private int numberOfPlayers;
    public static final int FOUR_QTY = 4;
    public static final int FIVE_QTY = 5;

    public Deck(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        populateDeck();
    }

    public void putIntoDeck(Card card) {
        cards.add(card);
    }

    public void drawFromDeck(Card card) {
        cards.remove(card);
    }

    private void populateDeck() {
        //Inserisco tutte le carte azione nel mazzo
        addCardsToDeck(FOUR_QTY, new AttackCard());
        addCardsToDeck(FOUR_QTY, new FavorCard());
        addCardsToDeck(FOUR_QTY, new SkipCard());
        addCardsToDeck(FOUR_QTY, new ShuffleCard());
        addCardsToDeck(FIVE_QTY, new SeeTheFutureCard());
        addCardsToDeck(FIVE_QTY, new NopeCard());

        //Inserisco tutte le carte gatto nel mazzo
        addCardsToDeck(FOUR_QTY, new CattermelonCart());
        addCardsToDeck(FOUR_QTY, new TacoCatCard());
        addCardsToDeck(FOUR_QTY, new BeardedCat());
        addCardsToDeck(FOUR_QTY, new PotatoCatCard());
        addCardsToDeck(FOUR_QTY, new RainbowCatCard());

        //Inserisco i gatti esplosivi e i defuse in base al numero di giocatori
        addCardsToDeck(DeckUtil.setExplodingKittensQty(numberOfPlayers), new ExplodingKittenCard());
        addCardsToDeck(DeckUtil.setDefuseQty(numberOfPlayers), new DefuseCard());
    }

    public List<Card> getCards() {
        return cards;
    }

    private void addCardsToDeck(int numberOfCards, Card cardType) {
        for (int i = 0; i < numberOfCards; i++) {
            cards.add(cardType);
        }
    }
}
