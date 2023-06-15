package it.consulting.explodingkittens.game;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.card.special.DefuseCard;
import it.consulting.explodingkittens.card.special.ExplodingKittenCard;
import it.consulting.explodingkittens.game.util.DeckUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Deck deck;

    public void startGame(int numberOfPlayers) {
        deck = new Deck(numberOfPlayers);
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(deck));
            System.out.println("Player " + (i+1) + ": " + players.get(i).getCards());
        }
        //Inserisco i gatti esplosivi e i defuse in base al numero di giocatori
        deck.setCards(DeckUtil.addCardsToDeck(deck.getCards(),
                DeckUtil.setExplodingKittensQty(numberOfPlayers),
                new ExplodingKittenCard()));
        deck.setCards(DeckUtil.addCardsToDeck(deck.getCards(),
                DeckUtil.setDefuseQty(numberOfPlayers),
                new DefuseCard()));
    }

    public void drawCard(int playerNumber) {
        Random rand = new Random();
        Card card =  deck.getCards().get(rand.nextInt(deck.getCards().size()));
        deck.drawFromDeck(card);

        if (card instanceof ExplodingKittenCard) {
            System.out.println("ESPLOSIONE!!! Sei morto");
        } else {
            System.out.println(card);
            players.get(playerNumber-1).drawCard(card);
        }
    }

    public void playCard(int playerNumber, Card card) {
        if (players.get(playerNumber-1).getCards().contains(card)) {
            players.get(playerNumber-1).playCard(card);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.startGame(3);
        game.drawCard(1);
        game.drawCard(2);
    }

}
