package me.jonmuxu.battleshipgame.game;

import java.util.ArrayList;

import me.jonmuxu.battleshipgame.entities.CPU;
import me.jonmuxu.battleshipgame.gui.GameGUI;

public class Game {

	// this should be accessible from anywhere
	private GameGUI gui;
	private ArrayList<CPU> entities;
	private int boardWidth;
	private int boardHeight;
	private char symbol;
	
	public Game() {
		this.entities = new ArrayList<>();
		this.gui = new GameGUI(this);
		// test
		this.boardHeight = 10;
		this.boardWidth = 10;
		this.symbol = '~';
		//matchLoop();
		gui.menu();
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

	public ArrayList<CPU> getEntities() {
		return entities;
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public char getSymbol() {
		return symbol;
	}
	
}
