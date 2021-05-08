package me.jonmuxu.battleshipgame.entities;

import java.util.ArrayList;
import java.util.Random;

import me.jonmuxu.battleshipgame.game.Game;

public class CPU {

	private String name;
	private Board board;
	private ArrayList<Ship> shipList;
	private ArrayList<Point> targets;
	private Random rnd;
	private Point point;
	private CPU opponent;
	private Point targetShoot;
	private boolean targetMode;
	private int AILevel;

	public CPU(String name, int AILevel) {
		this.name = name;
		this.board = new Board(10, '~');
		this.shipList = new ArrayList<>();
		this.targets = new ArrayList<>();
		this.rnd = new Random();
		this.point = new Point();
		this.targetMode = false;
		this.AILevel = AILevel;

		shipList.add(new Ship("Carrier", 'C', 5));
		shipList.add(new Ship("BattleShip", 'B', 4));
		shipList.add(new Ship("Cruiser", 'R', 4));
		shipList.add(new Ship("Submarine", 'S', 3));
		shipList.add(new Ship("Destroyer", 'D', 2));
	}

	/*
	 * This method returns a boolean for two different cases: 
	 * Case 1: Returns true if the ship was hit or Returns false if the ship wasn't hit 
	 * Case 2: If the ship was hit, but the opponent doesn't have any more ships, it returns false
	 *
	 */
	public boolean shoot() {
		if (AILevel == 1) {
			randomShot();
			if (checkShip(this.point)) {
				return true;
			}
			return false;
		} else {
			if (!targetMode) {
				randomShot();
				if (checkShip(this.point)) {
					targets.add(new Point(point.getX() - 1, point.getY()));
					targets.add(new Point(point.getX(), point.getY() - 1));
					targets.add(new Point(point.getX() + 1, point.getY()));
					targets.add(new Point(point.getX(), point.getY() + 1));
					targetMode = true;
					return true;
				}
				return false;
			} else {
				targets.removeIf(p -> p.getX() < 0 || p.getX() > 9 || p.getY() < 0 || p.getY() > 9
						|| opponent.getBoard()[p.getY()][p.getX()] == 'o');
				targetShoot = targets.get(rnd.nextInt(targets.size()));
				if (checkShip(this.targetShoot)) {
					if (point.getX() == targetShoot.getX()) {
						targets.removeIf(p -> p.getX() != point.getX());
						if (targetShoot.getY() < point.getY()) {
							targetShoot.translate(0, -1);
						} else {
							targetShoot.translate(0, 1);
						}
					} else {
						targets.removeIf(p -> p.getY() != point.getY());
						if (targetShoot.getX() < point.getX()) {
							targetShoot.translate(-1, 0);
						} else {
							targetShoot.translate(1, 0);
						}
					}
					if (opponent.getShipList().isEmpty()) {
						return false;
					} else {
						return true;
					}
				} else {
					targets.remove(targetShoot);
					return false;
				}
			}
		}
	}

	private void randomShot() {
		if (AILevel == 3) {
			do {
				this.point.random(this.board.getSize());
			} while (opponent.getBoard()[point.getY()][point.getX()] == 'o'
					|| opponent.getBoard()[point.getY()][point.getX()] == 'x'
					|| (point.getY() + point.getX()) % 2 == 0);
		} else {
			do {
				this.point.random(this.board.getSize());
			} while (opponent.getBoard()[point.getY()][point.getX()] == 'o'
					|| opponent.getBoard()[point.getY()][point.getX()] == 'x');
		}

	}

	private boolean checkShip(Point p) {
		for (Ship ship : opponent.shipList) {
			if (opponent.getBoard()[p.getY()][p.getX()] == ship.getShipLetter()) {
				ship.hit();
				opponent.getBoard()[p.getY()][p.getX()] = 'x';
				if (ship.getHealth() == 0) {
					this.targetMode = false;
					this.targets.clear();
					opponent.shipList.remove(ship);
				}
				return true;
			}
		}
		opponent.getBoard()[p.getY()][p.getX()] = 'o';
		return false;
	}

	public CPU getOpponent() {
		return this.opponent;
	}

	public void setOpponent() {
		for (CPU cpu : Game.getEntities()) {
			if (cpu.hashCode() != this.hashCode()) {
				this.opponent = cpu;
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<Ship> getShipList() {
		return this.shipList;
	}
	
	public ArrayList<Point> getTargets() {
		return targets;
	}
	
	public Point getPoint() {
		return point;
	}

	public char[][] getBoard() {
		return this.board.getBoard();
	}

	public Board getBoardObject() {
		return this.board;
	}
}
