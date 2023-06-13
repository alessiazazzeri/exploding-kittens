package it.consulting.explodingkittens.game;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.card.special.DefuseCard;
import it.consulting.explodingkittens.card.special.ExplodingKittenCard;

import java.util.List;
import java.util.Random;

public class Hand {
    private List<Card> cards;
    private Deck deck;

    public Hand(Deck deck) {
        this.deck = deck;
    }

    public void startGame() {
        //aggiungo alla mano un defuse e quattro carte pescate dal mazzo
        cards.add(new DefuseCard());
        cards.add(getRandomCart());
        cards.add(getRandomCart());
        cards.add(getRandomCart());
        cards.add(getRandomCart());
    }

    public void drawCard(Card card) {
        if (!(card instanceof ExplodingKittenCard)) {
            cards.add(card);
        }
    }

    public void playCard(Card card) {
        cards.remove(card);
    }

    public List<Card> getCards() {
        return cards;
    }

    private Card getRandomCart() {
        Random rand = new Random();
        Card card =  deck.getCards().get(rand.nextInt(deck.getCards().size()));
        //se pesca un gatto esplosivo ripete l'azione
        if (!(card instanceof ExplodingKittenCard)) {
            return card;
        } else {
            return getRandomCart();
        }
    }
}
