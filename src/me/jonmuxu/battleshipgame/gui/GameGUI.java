package me.jonmuxu.battleshipgame.gui;

import java.util.Scanner;

import me.jonmuxu.battleshipgame.entities.CPU;
import me.jonmuxu.battleshipgame.game.Game;

public class GameGUI {

	private Scanner keyboard;
	private int gameSpeed;

	public GameGUI(Game game) {
		this.keyboard = new Scanner(System.in);
	}

	public int level() {
		clearScreen();
		System.out.println("-------------[BattleShipGame2D]-------------");
		System.out.println("Please specify an AILevel to test: ");
		System.out.println("[1] Random Shots");
		System.out.println("[2] Random Shots + Hunt Mode");
		System.out.println("[3] Parity Shots + Hunt Mode");
		System.out.println("--------------------------------------------");
		int choice = keyboard.nextInt();
		return choice;
	}
	
	public void speed() {
		clearScreen();
		System.out.println("-------------[BattleShipGame2D]-------------");
		System.out.println("Please specify the game speed: ");
		System.out.println("[1] Slow");
		System.out.println("[2] Medium");
		System.out.println("[3] Fast");
		System.out.println("--------------------------------------------");
		int choice = keyboard.nextInt();
		switch (choice) {
			case 1:
				gameSpeed = 400;
				break;
				
			case 2:
				gameSpeed = 250;
				break;
				
			case 3:
				gameSpeed = 100;
				break;
		}
	}

	public void displayBoards() {
		clearScreen();
		for (CPU cpu : Game.getEntities()) {
			System.out.println("Name: " + cpu.getName() + "\nShips: " + cpu.getShipList() 
								+ "\nPoint: " + cpu.getPoint() + "\nTargets: " + cpu.getTargets() 
		                        + "\n" + cpu.getBoardObject());
		}
		try {Thread.sleep(gameSpeed);} catch (Exception e) {}
	}
	
	private static void clearScreen() {
		try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {}
	}

	

	

}
