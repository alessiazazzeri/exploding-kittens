package it.consulting.explodingkittens.game;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.card.special.DefuseCard;
import it.consulting.explodingkittens.card.special.ExplodingKittenCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    private List<Card> cards;
    private Deck deck;
    private boolean isAlive;

    public Player(Deck deck) {
        this.deck = deck;
        cards = getInitialCards();
        isAlive = true;
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

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    private List<Card> getInitialCards() {
        cards = new ArrayList<>();
        //aggiungo alla mano un defuse e quattro carte pescate dal mazzo
        cards.add(new DefuseCard());
        cards.add(getRandomCart());
        cards.add(getRandomCart());
        cards.add(getRandomCart());
        cards.add(getRandomCart());
        return cards;
    }

    private Card getRandomCart() {
        Random rand = new Random();
        Card card =  deck.getCards().get(rand.nextInt(deck.getCards().size()));
        deck.drawFromDeck(card);
        return card;
    }
}
