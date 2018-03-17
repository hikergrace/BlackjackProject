package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class GameApp {
	

	public static void main(String[] args) {
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println("~~~~  Welcome to Grace's Casino  ~~~~");
		System.out.println("~~~~  Let's play some Blackjack  ~~~~");
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		game.start(scanner);
		
		
		
		
		
		
		scanner.close();
	}
	
}