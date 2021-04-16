package me.jonmuxu.battleshipgame.game;

import me.jonmuxu.battleshipgame.entities.CPU;

public class Game {

	public static int boardWidth;
	public static int boardHeight;
	public static char symbol;
	
	// This is just for testing purposes, remove later
	public static void main(String[] args) {
		boardHeight = 10;
		boardWidth = 10;
		symbol = '~';
		CPU c = new CPU("");
		System.out.println(c.getBoard());
	}
	
}
