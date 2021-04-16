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
		CPU c1 = new CPU("");
		CPU c2 = new CPU("");
		CPU c3 = new CPU("");
		
		System.out.println(c.getBoard());
		System.out.println(c1.getBoard());
		System.out.println(c2.getBoard());
		System.out.println(c3.getBoard());
	}
	
}
