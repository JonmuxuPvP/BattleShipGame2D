package me.jonmuxu.battleshipgame.gui;

import java.util.Scanner;

import me.jonmuxu.battleshipgame.entities.CPU;
import me.jonmuxu.battleshipgame.entities.Player;
import me.jonmuxu.battleshipgame.game.Game;

public class GameGUI {

	private Scanner keyboard;
	private Game game;

	public GameGUI(Game game) {
		this.keyboard = new Scanner(System.in);
		this.game = game;
	}

	public void menu() {
		System.out.println("-------------[BattleShipGame2D]-------------");
		System.out.println("[1] Adventure Mode");
		System.out.println("[2] Free Play Mode");
		System.out.println("[3] Settings");
		System.out.println("[4] Exit");
		System.out.println("--------------------------------------------");

		int choice = keyboard.nextInt();

		switch (choice) {
			case 1:
				break;
	
			case 2:
				freePlayMenu();
				break;
	
			case 3:
	
				break;
			
			case 4:
				
				break;

		}

	}
	
	private void freePlayMenu() {
		System.out.println("-------------[BattleShipGame2D]-------------");
		System.out.println("[1] Player vs Player");
		System.out.println("[2] Player vs CPU");
		System.out.println("[3] CPU vs CPU");
		System.out.println("[4] Back");
		System.out.println("--------------------------------------------");
		
		int choice = keyboard.nextInt();
		
		switch (choice) {
			case 1:
				freePlayPvP();
				break;
			
		}
	}
	
	private void freePlayPvP() {
		for (int i = 0; i <= 2; i++) {
			System.out.println("-------------[BattleShipGame2D]-------------");
			System.out.println("[Select Your Name]");
			System.out.println("--------------------------------------------");
			
			String name = keyboard.nextLine();
			CPU c = new CPU(name, this.game);
			shop(c);
			game.getEntities().add(c);
		}
	}
	
	private void shop(CPU cpu) {
		String choice = "";
		while (choice != "Done") {
			System.out.println("-------------[BattleShipGame2D]-------------");
			System.out.println("Buy your Ships | Type \"Done\" when you are done");
			System.out.println("[1] Carrier - 750$");
			System.out.println("[2] BattleShip - 1000$");
			System.out.println("[3] Cruiser - 2200$");
			System.out.println("[4] Submarine - 2500$");
			System.out.println("[5] Destroyer - 3000$");
			System.out.println("\nYour Money: " + cpu.getBalance() + "$");
			System.out.println("--------------------------------------------");
			choice = keyboard.next();
		}
	}

	public void settings() {

	}

	public void adventureMode() {

	}

	public void freePlay() {

	}

}
