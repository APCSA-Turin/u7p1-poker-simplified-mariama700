package com.example.project;
import java.util.ArrayList;

public class Game {
    
    public static String determineWinner(Player p1, Player p2, String p1Hand, String p2Hand, ArrayList<Card> communityCards) {
        int p1Rank = Utility.getHandRanking(p1Hand); // get p1 hand rank
        int p2Rank = Utility.getHandRanking(p2Hand); // get p2 hand rank

        if (p1Rank > p2Rank) { 
            return "Player 1 wins!";
        } 
        if (p2Rank > p1Rank) { 
            return "Player 2 wins!";
        }

        // get all cards
        ArrayList<Card> p1Cards = p1.getAllCards();
        ArrayList<Card> p2Cards = p2.getAllCards();

        // sort both hands
        sortCards(p1Cards);
        sortCards(p2Cards);

        // compare cards from highest to lowest
        for (int i = 0; i < p1Cards.size() && i < p2Cards.size(); i++) {
            int p1CardValue = Utility.getRankValue(p1Cards.get(i).getRank());
            int p2CardValue = Utility.getRankValue(p2Cards.get(i).getRank());
            if (p1CardValue > p2CardValue) { 
                return "Player 1 wins!";
            } 
            if (p2CardValue > p1CardValue) { 
                return "Player 2 wins!";
            }
        }
        return "Tie!"; // hands are equal
    }

    // sort cards in descending order, modified slightly compared to sort method in Player class
    private static void sortCards(ArrayList<Card> cards) {
        for (int i = 0; i < cards.size() - 1; i++) {
            int maxIndex = i; // max at i
            for (int j = i + 1; j < cards.size(); j++) {
                if (Utility.getRankValue(cards.get(j).getRank()) > Utility.getRankValue(cards.get(maxIndex).getRank())) {
                    maxIndex = j; // update max index
                }
            }
            // swap max card with current card
            Card temp = cards.get(i);
            cards.set(i, cards.get(maxIndex));
            cards.set(maxIndex, temp);
        }
    }
}
