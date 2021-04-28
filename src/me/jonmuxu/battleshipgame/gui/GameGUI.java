package me.jonmuxu.battleshipgame.gui;

import java.util.Scanner;

import me.jonmuxu.battleshipgame.entities.CPU;
import me.jonmuxu.battleshipgame.entities.Player;
import me.jonmuxu.battleshipgame.entities.Shop;
import me.jonmuxu.battleshipgame.game.Game;

public class GameGUI {

	private Scanner keyboard;
	private Game game;

	public GameGUI(Game game) {
		this.keyboard = new Scanner(System.in);
		this.game = game;
	}

	public void menu() {
		clearScreen();
		System.out.println("-------------[BattleShipGame2D]-------------");
		System.out.println("[1] Adventure Mode");
		System.out.println("[2] Free Play Mode");
		System.out.println("[3] Settings");
		System.out.println("[4] Exit");
		System.out.println("--------------------------------------------");
		int choice = keyboard.nextInt();
		
		switch (choice) {
			case 2:
				game.start();
				break;
			default:
				System.out.println("no");
				
		}
	
	}

	// TODO xd
	public void freePlayMenu() {
		System.out.println("-------------[BattleShipGame2D]-------------");
		System.out.println("[1] Player vs Player");
		System.out.println("[2] Player vs CPU");
		System.out.println("[3] CPU vs CPU");
		System.out.println("[4] Back");
		System.out.println("--------------------------------------------");
	}
	
	public void freePlayPvP() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Your name: ");
			String name = keyboard.nextLine();
			Player p = new Player(name);
			Game.getEntities().add(p);
			shop(p);			
		}
	}
	
	// TODO no va
	public void shop(Player p) {
		clearScreen();
		String choice;
		do {
			System.out.println("-------------[BattleShipGame2D]-------------");
			for (int i = 0; i < Shop.getShipList().length; i++) {
				System.out.println("[" + (i + 1) + "] " + Shop.getShipList()[i].getName() + " - " 
			                       + Shop.getShipList()[i].getPrice() + "$");
			}
			System.out.println("Balance: " + p.getBalance());
			System.out.println("--------------------------------------------");
			choice = keyboard.nextLine();
			Shop.buyShip(p, choice);
		} while (choice != "Done");
	}
	

	public static void displayBoards() {
		for (CPU cpu : Game.getEntities()) {
			System.out.println(cpu.getName() + "\n" + cpu.getShipList() + "\n" + cpu.getBoardObject() + "\n");
		}
		try {Thread.sleep(100);} catch (Exception e) {}
		clearScreen();
	}
	
	private static void clearScreen() {
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {}
	}

	public void settings() {

	}

}
