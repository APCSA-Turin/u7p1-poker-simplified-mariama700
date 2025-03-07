package com.example.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Poker {
    private Deck deck = new Deck();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private ArrayList<Card> communityCards = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void startGame() {
        System.out.println("════════════════════════════════");
        System.out.println("   WELCOME TO MARIAM'S CASINO.  ");
        System.out.println("════════════════════════════════\n");
        while (true) {
            System.out.println("1. Start Game");
            System.out.println("2. Exit");
            System.out.print("\nSelect an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 2) break;
            playRound();
        }
        System.out.println("\nThank you for playing at Mariam's Casino.");
    }

    private void playRound() {
        resetGame();
        System.out.println("\nShuffling deck...");
        System.out.println("Dealing hands...\n");

        dealCards();

        System.out.println("\nCommunity Cards:");
        for (int i = 0; i < 5; i++) {
            communityCards.add(deck.drawCard());
            printCard(communityCards.get(i));
        }

        // Determine best hands & winner
        String p1BestHand = player1.playHand(communityCards);
        String p2BestHand = player2.playHand(communityCards);
        String result = Game.determineWinner(player1, player2, p1BestHand, p2BestHand, communityCards);

        System.out.println("\n════════════════════════");
        System.out.println("      FINAL RESULT.       ");
        System.out.println("════════════════════════");
        System.out.println("Player 1: " + p1BestHand);
        System.out.println("Player 2: " + p2BestHand);
        System.out.println("Winner: " + result);
    }

    private void resetGame() {
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
        communityCards.clear();
    }

    private void dealCards() {
        for (int i = 0; i < 2; i++) {
            player1.addCard(deck.drawCard());
            player2.addCard(deck.drawCard());
        }
        System.out.println("Player 1: " + player1.getHand());
        System.out.println("Player 2: " + player2.getHand());
    }

    private void printCard(Card card) {
        System.out.println("[" + card + "]");
    }

    public static void main(String[] args) {
        new Poker().startGame();
    }
}
