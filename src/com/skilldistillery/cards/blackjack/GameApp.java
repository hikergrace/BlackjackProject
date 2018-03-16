package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class GameApp {
	private Deck deck = new Deck();

	public static void main(String[] args) {
		GameApp dealing = new GameApp();
		Scanner scanner = new Scanner(System.in);
		scanner.close();
	}
	
	private void start(Scanner scanner) {
		deck.shuffle();
		
		System.out.println("How many cards do you want?");
		int howMany = 0;
		try {
			howMany = scanner.nextInt();
		} catch (InputMismatchException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("That's not a number");
			
		}
		if(howMany > 52) {
			System.out.println("Not enough cards for that");
			return; //WILL NEED TO ACCOUNT FOR USER ASKING FOR TOO MANY
		}
		
		for (int i = 0; i < howMany; i++) {
			Card card = deck.dealCard();
			
			System.out.println(card);
		}
		System.out.println("There are " + deck.checkDeckSize() + "cards left.");
	}
}