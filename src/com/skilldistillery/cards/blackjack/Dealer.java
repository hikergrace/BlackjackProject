package com.skilldistillery.cards.blackjack;

import java.util.Collections;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer {
	
	private Hand hand = new Hand();
	private Deck deck = new Deck();
	
	public Hand getHand() {
		return hand;
	}

	public Deck getDeck() {
		return deck;
	}

	public int getValueOfHand() {
		int counter = 0;
		for (Card card : hand.getCardsInHand()) {
			counter += card.getValue();
		}
		return counter;
	}
	
	public boolean dealerBusted() {
		if (getValueOfHand() > 21) {
			return true;
		}
		return false;
	}
}
