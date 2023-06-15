package it.consulting.explodingkittens.game.actions;

import it.consulting.explodingkittens.card.Card;

import java.util.List;

public class FavorAction extends CardAction {
    private int chosenPlayerNumber;
    private int actionPlayerNumber;
    private Card card;

    public FavorAction(int chosenPlayerNumber, int actionPlayerNumber, Card card) {
        this.chosenPlayerNumber = chosenPlayerNumber;
        this.actionPlayerNumber = actionPlayerNumber;
        this.card = card;
    }

    public Card chooseCard() {
        return super.getPlayer(chosenPlayerNumber).
                getCards().stream().filter(c -> c.equals(card)).findFirst().orElseThrow();
    }

    @Override
    void execute() {
        Card newCard = chooseCard();
        List<Card> chosenPlayerCards = super.getPlayer(chosenPlayerNumber).getCards();
        List<Card> actionPlayerCards = super.getPlayer(actionPlayerNumber).getCards();

        chosenPlayerCards.remove(newCard);
        super.getPlayer(chosenPlayerNumber).setCards(chosenPlayerCards);

        actionPlayerCards.add(newCard);
        super.getPlayer(actionPlayerNumber).setCards(actionPlayerCards);

    }
}
