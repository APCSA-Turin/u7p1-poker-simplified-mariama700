package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        initializeDeck();
        shuffleDeck();
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public  void initializeDeck(){ //hint.. use the utility class
        String[] ranks = Utility.getRanks();
        String[] suits = Utility.getSuits();
        for (int i = 0; i < 4; i++) {
            String suit = suits[i];
            for (String rank : ranks) {
                Card card = new Card(rank, suit);
                cards.add(card);
            }
        }
    }

    public  void shuffleDeck(){ //You can use the Collections library or another method. You do not have to create your own shuffle algorithm
        Collections.shuffle(cards);
    }

    public  Card drawCard(){
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }


    public boolean isEmpty(){
        return cards.isEmpty();
    }
}