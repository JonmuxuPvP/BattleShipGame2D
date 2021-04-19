package me.jonmuxu.battleshipgame.game;

import java.util.ArrayList;

import me.jonmuxu.battleshipgame.entities.CPU;

public class Game {

	// this should be accessible from anywhere
	public static ArrayList<CPU> entities;
	public static int boardWidth;
	public static int boardHeight;
	public static char symbol;
	
	public Game() {
		this.entities = new ArrayList<>();
		// test
		this.boardHeight = 10;
		this.boardWidth = 10;
		this.symbol = '~';
		entities.add(new CPU("CPU1", this));
		entities.add(new CPU("CPU2", this));
		matchLoop();
	}
	
	public void menu() {
		
	}

	// think about displaying boards after each shot
	public void matchLoop() {
		for (CPU cpu : entities) {
			cpu.getBoardObject().placeShips(cpu.getShipList());
			cpu.setOpponent();
		}
		displayBoards();
		
		while (true) {
			for (CPU cpu : entities) {
				if (cpu.getShipList().isEmpty() || cpu.getTotalAmmo() == 0) {
					System.out.println(cpu.getOpponent().getName() + " wins!");
					return;
				}
				while (cpu.shoot());
			}
			
		}
		
	}

	// debugging purposes
	public void displayBoards() {
		for (CPU cpu : entities) {
			System.out.println(cpu.getName() + "\n" + cpu.getShipList() + "\n" + cpu.getBoardObject() + "\n");
		}
		try {Thread.sleep(200);} catch (Exception e) {}
		
	}
	
}
