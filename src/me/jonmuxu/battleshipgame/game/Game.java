package me.jonmuxu.battleshipgame.game;

import java.util.ArrayList;

import me.jonmuxu.battleshipgame.entities.CPU;
import me.jonmuxu.battleshipgame.gui.GameGUI;

public class Game {

	private GameGUI gui;
	private static ArrayList<CPU> entities;
	private int level;

	public Game() {
		Game.entities = new ArrayList<>();
		this.gui = new GameGUI(this);
		this.level = gui.level();
		gui.speed();
		start();
	}
	
	public void start() {
		entities.add(new CPU("CPU 1", level));
		entities.add(new CPU("CPU 2", level));
		matchLoop();
	}

	public void matchLoop() {
		for (CPU cpu : entities) {
			cpu.getBoardObject().placeShips(cpu.getShipList());
			cpu.setOpponent();
		}
		while (true) {
			for (CPU cpu : entities) {
				if (cpu.getShipList().isEmpty()) {
					gui.displayBoards();
					System.out.println("---------\n" + cpu.getOpponent().getName() + " wins!\n---------");
					return;
				}
				do {
					gui.displayBoards();
				} while (cpu.shoot());
			}

		}
	}
	public static ArrayList<CPU> getEntities() {
		return Game.entities;
	}



}
