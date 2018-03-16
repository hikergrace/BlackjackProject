package com.skilldistillery.cards.blackjack;

public class Player {
	public String name;
	public Hand hand;
	public double wallet;

	public String getName() {
		return name;
	}

	public Player(String name, Hand hand, double wallet) {
		super();
		this.name = name;
		this.hand = hand;
		this.wallet = wallet;
	}

	public Player() {

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
}
