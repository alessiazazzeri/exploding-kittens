package it.consulting.explodingkittens.game;

import it.consulting.explodingkittens.card.special.DefuseCard;
import it.consulting.explodingkittens.card.special.ExplodingKittenCard;
import it.consulting.explodingkittens.game.util.DeckUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private Deck deck;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame(int numberOfPlayers) {
        deck = new Deck(numberOfPlayers);
        System.out.println(deck.getCards());
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
        System.out.println(deck.getCards().size());
    }

    public static void main(String[] args) {
        Game game = new Game();

        game.startGame(3);
    }

}
