package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Game {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Deck deck = new Deck();

	public void start(Scanner scanner) {
		dealer.getDeck().shuffle();

		player.getHand().addCard(dealer.getDeck().dealCard());
		dealer.getHand().addCard(dealer.getDeck().dealCard());
		player.getHand().addCard(dealer.getDeck().dealCard());
		dealer.getHand().addCard(dealer.getDeck().dealCard());

		System.out.println(
				"Your hand is: " + player.getHand() + " and the value is " + player.getHand().getValueOfHand());
		System.out.println("The dealer is showing: " + dealer.getHand().getTopCard());

		System.out.println("Player, do you want to HIT or STAY (type hit or stay)");
		String playerChoice = scanner.next();

		while (playerChoice.equalsIgnoreCase("hit")) {
			playerHit();
			System.out.println(
					"Your hand is: " + player.getHand() + " and the value is " + player.getHand().getValueOfHand());
			if (player.playerBusted()) {
				System.out.println("You busted 21. We're starting a new hand.");
				player.getHand().clearHand();
				start(scanner);
			}
			System.out.println("Player, do you want to HIT or STAY (type hit or stay)");
			playerChoice = scanner.next();
		}
		if (dealer.getValueOfHand() < 17) {
			dealerHit();
			System.out.println("The dealer's hand is " + dealer.getHand() + " and the value is "
					+ dealer.getHand().getValueOfHand());
		}

		checkIfPlayerWon();

		// PLAYER CHOOSING STAY
		if (playerChoice.equalsIgnoreCase("stay")) {
			System.out.println(
					"Your hand is: " + player.getHand() + " and the value is " + player.getHand().getValueOfHand());
		}

	}

	public void playerHit() {
		player.getHand().addCard(dealer.getDeck().dealCard());
	}

	public void dealerHit() {
		dealer.getHand().addCard(dealer.getDeck().dealCard());

	}

	public boolean checkIfPlayerWon() {
		if (dealer.dealerBusted()) {
			System.out.println(
					"Your hand is: " + player.getHand() + " and the value is " + player.getHand().getValueOfHand());
			System.out.println("You busted 21 and lost");
			return true;
		} else {
			return false;
		}

	}
}
