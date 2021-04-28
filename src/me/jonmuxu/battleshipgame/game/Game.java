package me.jonmuxu.battleshipgame.game;

import java.util.ArrayList;

import me.jonmuxu.battleshipgame.entities.CPU;
import me.jonmuxu.battleshipgame.gui.GameGUI;

public class Game {

	private GameGUI gui;
	private static ArrayList<CPU> entities;

	public Game() {
		Game.entities = new ArrayList<>();
		this.gui = new GameGUI(this);
		
		gui.menu();
	}
	
	public void start() {
		entities.add(new CPU("Marincon"));
		entities.add(new CPU("yo mismo"));
		matchLoop();
	}

	// think about displaying boards after each shot
	public void matchLoop() {
		for (CPU cpu : entities) {
			cpu.getBoardObject().placeShips(cpu.getShipList());
			cpu.setOpponent();
		}
		gui.displayBoards();

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

	
	

	public static ArrayList<CPU> getEntities() {
		return Game.entities;
	}



}
