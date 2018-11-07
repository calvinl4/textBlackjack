package blackjack;

import java.util.*;

public class Deck {
	private ArrayList<Card> cardarr = new ArrayList<Card>();

	public Deck() {
		for (int i = 1; i <= 13; i++) {
			for (int k = 1; k <= 4; k++) {
				cardarr.add(new Card(i,k));	
			}
		}
	}
	
	Random rand = new Random();
	
	public void shuffle() {
		for (int i = 0; i < 1000; i++) {
			int n = rand.nextInt(cardarr.size());
			int j = rand.nextInt(cardarr.size());
			Card oldCard = cardarr.get(n);
			cardarr.set(n, cardarr.get(j));	
			cardarr.set(j, oldCard);
		}
	}
	
	public Card draw() {
		Card drewCard = cardarr.get(cardarr.size() - 1);
		cardarr.remove(cardarr.size() - 1);
		return drewCard;
	}
	
	
}
