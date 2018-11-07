package blackjack;

import java.util.*;

public class Card {
	private int rank;
	private int suit;
	private int value;
	
	public Card(int newRank, int newSuit) {
		rank = newRank;
		suit = newSuit;
		if (newRank == 1) {
			value = 11;
		}
		else if (newRank > 10) {
			value = 10;
		}
		else {
			value = newRank;
		}
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getSuit() {
		return suit;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setRank(int newRank) {
		rank = newRank;
		if (newRank == 1) {
			value = 11;
		}
		else if (newRank > 10) {
			value = 10;
		}
		else {
			value = newRank;
		}
	}
	
	public void setSuit(int newSuit) {
		suit = newSuit;
	}
	
	public String toString() {
		String cardName = "";
		String cardSuit = "";
		if (rank == 1) {
			cardName = "Ace";
		}
		else if (rank == 11) {
			cardName = "Jack";
		}
		else if (rank == 12) {
			cardName = "Queen";
		}
		else if (rank == 13) {
			cardName = "King";
		}
		else {
			cardName = Integer.toString(rank);
		}
		if (suit == 1) {
			cardSuit = "Spades";
		}
		else if (suit == 2) {
			cardSuit = "Hearts";
		}
		else if (suit == 3) {
			cardSuit = "Clubs";
		}
		else {
			cardSuit = "Diamonds";
		}
		
		
		return "Card: " + cardName + " of " + cardSuit;
	}
}
