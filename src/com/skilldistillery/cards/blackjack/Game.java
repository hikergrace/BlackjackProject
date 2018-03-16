package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Game {
	// create dealer and player
	private Dealer dealer = new Dealer();
	private Player player = new Player();
	private Deck deck = new Deck();

	private void start(Scanner scanner) {
		// dealer deals
		// create hands
		Deck dealerHand = dealer.getDeck(); //.shuffle();
		Hand playerHand = player.getHand();

		// player can choose Hit or Stay
		System.out.println("Player, do you want to HIT or STAY (type hit or stay)");
		String playerChoice = scanner.next();
		
		Card dealt = deck.dealCard();
		
		if(playerChoice.equalsIgnoreCase("hit")) {
			playerHand.addCard(dealt);
		} 
		else {
			playerHand.getValueOfHand();
		}
		
//		if(dealerHand.getValueOfHand < 17) {
//		dealerHand.addCard(dealt);
//		} 
		
		// compare who is higher but <= 21 is the winner
		
		// if dealer < 17 call dealCard() ELSE stay
		// if dealer or player >= 21 GAME OVER


	}
}
