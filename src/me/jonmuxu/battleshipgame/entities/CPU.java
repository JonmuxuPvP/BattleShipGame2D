package me.jonmuxu.battleshipgame.entities;

import java.util.ArrayList;
import java.util.Random;

import me.jonmuxu.battleshipgame.game.Game;

public class CPU {
	
	protected String name;
	protected Board board;
	protected ArrayList<Ship> shipList;
	protected ArrayList<Point> targets;
	protected Random rnd;
	protected Point point;
	protected CPU opponent;
	protected Point targetShoot;
	protected boolean targetMode;
	protected int AILevel;
	
	public CPU(String name) {
		this.name = name;
		this.board = new Board(Game.boardWidth, Game.boardHeight, Game.symbol);
		this.shipList = new ArrayList<>();
		this.targets = new ArrayList<>();
		this.rnd = new Random();
		this.point = new Point();
		this.targetMode = false;
		this.AILevel = 0;
	}
	
	public Board getBoard() {
		return board;
	}
	
	
	
}
