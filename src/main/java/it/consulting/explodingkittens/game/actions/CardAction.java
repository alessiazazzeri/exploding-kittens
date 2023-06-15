package it.consulting.explodingkittens.game.actions;

import it.consulting.explodingkittens.card.Card;
import it.consulting.explodingkittens.game.Deck;
import it.consulting.explodingkittens.game.Player;

import java.util.List;

public abstract class CardAction {
    private List<Card> deckCards;
    private List<Player> players;

    abstract void execute();

    public List<Card> getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(List<Card> deckCards) {
        this.deckCards = deckCards;
    }

    public Player getPlayer(int playerNumber) {
        return players.get(playerNumber);
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
