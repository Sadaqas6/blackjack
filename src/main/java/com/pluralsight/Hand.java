package com.pluralsight;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }


    public void deal(Card card) {
        cards.add(card);  // adds the card to the list
    }

    public int getSize() {
        return cards.size(); // gets the number of cards in the list
    }

    public Card getCard(int index) {
        return cards.get(index); // gets card position at the index
    }


    public int getValue() {
        int value = 0;
        for (Card card : cards) {
            card.flip(); // turn the card over to see the value
            value += card.getPointValue(); // adds points
            card.flip(); // hide the card again
        }
        return value;
    }
}
