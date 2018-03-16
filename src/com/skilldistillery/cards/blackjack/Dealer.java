package com.skilldistillery.cards.blackjack;

import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer {
	
	private Hand hand = new Hand();
	
	public Hand getHand() {
		return hand;
	}

	private Deck deck = new Deck();
	
	private void shuffle() {
		Collections.shuffle((List<Card>) deck);
	}
	
	private Card dealsCard() {
		return deck.dealCard();
	}

	public Deck getDeck() {
		return deck;
	}

//	public int getValueOfHand() {
//		int counter = 0;
//		for (Card card : hand) {
//			counter += card.getValue();
//		}
//		return counter;
	}
//}
