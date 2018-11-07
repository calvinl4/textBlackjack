package blackjack;

import java.util.*;

public class Hand {
	private ArrayList<Card> cardarr = new ArrayList<Card>();
	private int totalValue;
	public boolean over21 = false;
	private boolean isDealer;

	public Hand(boolean isDealer) {
		if (isDealer) {
			totalValue = 0;
			this.isDealer = true;
		} else {
			totalValue = 0;
			this.isDealer = false;
		}
	}

	public int get_totalValue() {
		return totalValue;
	}

	public void addCard(Card addedCard) {
		cardarr.add(addedCard);
		totalValue += addedCard.getValue();
		if (totalValue > 21) {
			over21 = true;
		}
	}
	
	public void set_dealer() {
		isDealer = true;
	}
	
	public void set_player() {
		isDealer = false;
	}
	
	public void cardReveal() {
		System.out.println("The dealer's first " + cardarr.get(0) + ". His total was " + get_totalValue() + ".");
	}

	public String toString() {
		String stringOutput = "";
		if (isDealer) {
			stringOutput += "Dealer's Hand: \n";
		}
		else {
			stringOutput += "Player's Hand: \n";
		}
		for (int i = 0; i < cardarr.size(); i++) {
			if (i == 0 && isDealer) {
				stringOutput += "\tCard: ????? \n";
			} else {

				stringOutput += "\t" + cardarr.get(i) + "\n";

			}
		}
		if (!isDealer) {
			stringOutput += "\tCurrent Value: " + get_totalValue() + "\n";
		}
		return stringOutput;
	}
}
