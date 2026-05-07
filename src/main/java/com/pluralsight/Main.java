package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        System.out.print("How many players? ");
        int numPlayers = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Enter the player name: ");
            String playerName = sc.nextLine();
            players.add(new Player(playerName));
        }
        // Creating deck and shuffling
        Deck deck = new Deck();
        deck.shuffle();

        // Dealing  2 cards to each player
        for (Player player : players) {
            player.getHand().deal(deck.deal());
            player.getHand().deal(deck.deal());
        }
        for (Player player : players) {
            System.out.println(player.getName() + "'s hand:");

            for (int i = 0; i < player.getHand().getSize(); i++) {
                Card card = player.getHand().getCard(i);
                card.flip();
                System.out.println(card.getValue() + " of " + card.getSuit());
                card.flip();
            }
            System.out.println("Total: " + player.getHand().getValue());
        }

        int bestScore = 0;
        Player winner = null;

        for (Player player : players) {
            int score = player.getHand().getValue();
            if (score <= 21 && score > bestScore) {
                bestScore = score;
                winner = player;
            }
        }

        System.out.println("Winner is: " + winner.getName());


    }
}
