package com.pluralsight;

public class Card {

    // Fields or backing variables
    private String suit;
    private String value;
    private boolean isFaceUp;

    public Card(String suit, String value) {

        this.suit = suit;
        this.value = value;
        this.isFaceUp = false;
    }

    public String getSuit() {
        // only return the suit if the card is face up
        if (isFaceUp) {
            return suit;
        } else {
            return "#";
        }
    }

    public String getValue() {
        // only return the value if the card is face up
        if (isFaceUp) {
            return value;  // show value
        } else {
            return "#";  // hide value
        }
    }

    public int getPointValue() {
        // only return the value if the card is face up
        if (isFaceUp) {
            if (value.equals("A")) {
                return 11;  // Ace == 11
            } else if (value.equals("K") || value.equals("Q") || value.equals("J")) {
                return 10;  // Face cards == 10
            } else {
                return Integer.parseInt(value); // Converts "7" to 7
            }
        }
        return 0;
    }

    public boolean isFaceUp() {
        return isFaceUp;
    }

    public void flip() {
        isFaceUp = !isFaceUp;
    }
}



