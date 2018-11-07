package blackjack;

import java.util.*;

public class Blackjack {

	public static void main(String[] args) {
		while (amount > 0) {
			System.out.println("You have $" + amount + " to play Blackjack.");
			getBet();
			System.out.println("");

			deck = new Deck();

			playerHand = new Hand(false);
			dealerHand = new Hand(true);

			deck.shuffle();
			playerHand.addCard(deck.draw());
			playerHand.addCard(deck.draw());
			dealerHand.addCard(deck.draw());
			dealerHand.addCard(deck.draw());

			System.out.println(playerHand);
			System.out.println(dealerHand);

			playerTurn();

			if (!playerHand.over21) {
				dealerTurn();
			}

			if (winner.equals("Dealer")) {
				amount -= bet;
				System.out.println("The dealer has won this round!");
			} else if (winner.equals("Player")) {
				amount += bet;
				System.out.println("The player has won this round!");
			} else {
				System.out.println("Tie Game.");
			}
			System.out.println("");
		}
		
		
	}

	static Scanner s = new Scanner(System.in);

	static int amount = 1000;
	static int bet;
	static String winner = "";
	static Deck deck;
	static Hand playerHand;
	static Hand dealerHand;

	public static void getBet() {
		System.out.print("How much would you like to bet?: ");
		bet = s.nextInt();
		s.nextLine();
		while (bet > amount || bet <= 0) {
			bet = s.nextInt();
			s.nextLine();
		}

	}

	public static void playerTurn() {
		while (true) {
			System.out.print("Would you like to hit or stand?: ");
			String decision = s.nextLine();
			if (decision.equals("hit")) {
				playerHand.addCard(deck.draw());
				System.out.println(playerHand);
			} else {
				System.out.println(playerHand);
				return;
			}
			if (playerHand.over21 == true) {
				System.out.println("Your hand is busted!");
				winner = "Dealer";
				return;
			}
		}
	}

	public static void dealerTurn() {
		System.out.println("Dealer's Turn: ");
		while (dealerHand.get_totalValue() < playerHand.get_totalValue()) {
			dealerHand.addCard(deck.draw());
			if (dealerHand.over21 == true) {
				dealerHand.cardReveal();
				System.out.println("The dealer's hand is busted!");
				winner = "Player";
				return;
			} else {
				winner = "Dealer";
			}
		}
		System.out.println("The dealer decides to stand!");
		dealerHand.cardReveal();

	}
}
