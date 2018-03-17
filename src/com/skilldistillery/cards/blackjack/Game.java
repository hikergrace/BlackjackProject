package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class Game {
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Deck deck = new Deck();

	public void start(Scanner scanner) {
		if (dealer.getDeck().checkDeckSize() <= 9) {
			dealer.dealerGetNewDeck();
			System.out.println("You are starting a new deck.");
		}
		dealer.getDeck().shuffle();

		System.out.println("Would you like to play? Please type yes or no.");
		String playerYN = scanner.next();

		if (playerYN.equalsIgnoreCase("No")) {
			System.out.println("Thanks for playing!");
			System.exit(0);
		}

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
				System.out.println("You busted 21. Sorry, you lose. ");
				clearRound(scanner);
			}
			System.out.println("Player, do you want to HIT or STAY (type hit or stay)");
			playerChoice = scanner.next();
		}
		while (dealer.getValueOfHand() < 17) {
			dealerHit();
			System.out.println("The dealer's hand is " + dealer.getHand() + " and the value is "
					+ dealer.getHand().getValueOfHand());
			if (dealer.dealerBusted()) {
				System.out.println("Dealer busted 21. You WON!");
				clearRound(scanner);
			}
		}

		if (dealer.getHand().getValueOfHand() == 21 && player.getHand().getValueOfHand() == 21) {
			System.out.println("Tied Game!");
			clearRound(scanner);
		}

		if (dealer.dealerBusted()) {
			System.out.println("Dealer busted 21. You WON!");
			clearRound(scanner);
		}
		if (checkIfPlayerWon()) {
			System.out.println("You beat the dealer with a hand of " + player.getHand().getValueOfHand()
					+ " to the dealer's hand of " + dealer.getHand().getValueOfHand() + ". Way to go!");
			clearRound(scanner);
		} else {
			System.out.println("You lost to the dealer with a hand of " + player.getHand().getValueOfHand()
					+ " to the dealer's hand of " + dealer.getHand().getValueOfHand() + ". Better luck next time.");
			clearRound(scanner);

		}

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

	public void clearRound(Scanner scanner) {
		dealer.getHand().clearHand();
		player.getHand().clearHand();
		start(scanner);
	}

	public boolean checkIfPlayerWon() {
		if ((player.getHand().getValueOfHand() > dealer.getHand().getValueOfHand())
				&& player.getHand().getValueOfHand() <= 21) {
			return true;
		}
		return false;
	}
}
