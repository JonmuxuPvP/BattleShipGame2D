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
		
		//testing purposes
		shipList.add(new Ship("Carrier", 'C', 5, 30));
		shipList.add(new Ship("BattleShip", 'B', 4, 30));
		shipList.add(new Ship("Submarine", 'S', 3, 30));
		shipList.add(new Ship("Cruiser", 'R', 3, 30));
		shipList.add(new Ship("Destroyer", 'D', 2, 30));
	}
	
	/* This method returns a boolean for two different cases:
	 * Case 1:
		   Returns true if the ship was hit
		   Returns false if the ship wasn't hit 
	   Case 2: 
	   	   If the ship was hit, but the opponent doesn't have any more ships, it returns false
	   */
	
	public boolean shoot() {
		boolean hit = false;
		randomCannonball();
		
		switch (AILevel) {
			case 0:
				randomShot();
				if (checkShip()) {
					opponent.getBoard()[point.getY()][point.getX()] = 'x';
					hit = true;
				} else {
					opponent.getBoard()[point.getY()][point.getX()] = 'o';
				}
			break;

		}
		return hit;
		
	}
	
	private void randomShot() {
		do {
			this.point.random(this.board.getLength());
		} while (opponent.getBoard()[point.getY()][point.getX()] == 'o' ||
				 opponent.getBoard()[point.getY()][point.getX()] == 'x');
	}
	
	private void randomCannonball() {
		for (Ship ship : shipList) {
			if (ship.getAmmo() > 0) {
				ship.shoot();
				return;
			}
		}
	}
	
	private boolean checkShip() {
		for (Ship ship : opponent.shipList) {
			if (opponent.getBoard()[point.getY()][point.getX()] == ship.getShipLetter()) {
				ship.hit();
				if (ship.getHealth() == 0) {
					this.targetMode = false;
					this.targets.clear();
					opponent.shipList.remove(ship);
				}
				return true;
			}
		}
		return false;
	}
	
	public CPU getOpponent() {
		return this.opponent;
	}
	
	public void setOpponent() {
		for (CPU cpu : Game.entities) {
			if (cpu.hashCode() != this.hashCode()) {
				this.opponent = cpu;
			}
		}
	}
	
	public int getTotalAmmo() {
		int count = 0;
		for (Ship ship : shipList) {
			count += ship.getAmmo();
		}
		return count;

	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Ship> getShipList() {
		return this.shipList;
	}
	
	public char[][] getBoard() {
		return this.board.getBoard();
	}
	
	public Board getBoardObject() {
		return this.board;
	}
	
	
	
}
