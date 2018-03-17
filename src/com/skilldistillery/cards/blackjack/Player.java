package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	private String name;
	private Hand hand;
	private double wallet;

	public Player() {
		hand = new Hand();
	}

	public Player(String name, double wallet) {
		this();
		this.name = name;
		this.wallet = wallet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public int getValueOfHand() {
		int counter = 0;
		for (Card card : hand.getCardsInHand()) {
			counter += card.getValue();
		}
		return counter;
	}

	public boolean playerBusted() {
		if (getValueOfHand() > 21) {
			return true;
		}
		return false;
	}
}
