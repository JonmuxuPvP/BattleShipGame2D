package me.jonmuxu.battleshipgame.entities;

import java.util.ArrayList;
import java.util.Random;

public class Board {

	private char[][] board;
	private char symbol;
	private Random rnd;
	
	public Board(int width, int height, char symbol) {
		this.board = new char[width][height];
		this.symbol = symbol;
		rnd = new Random();
		fillBoard();
	}
	
	public void placeShips(ArrayList<Ship> ships) {
		Point p = new Point();
		for (Ship ship : ships) {
			int pos = rnd.nextInt(2);
			do {
				p.random(board.length);
			} while (!checkShip(ship, p, pos));
				for (int i = 0; i < ship.getLength(); i++) {
					board[p.getY()][p.getX()] = ship.getShipLetter();
					increment(p, pos);
				}
			}
	}
	
	private boolean checkShip(Ship ship, Point p, int pos) {
		int x = p.getX();
		int y = p.getY();
		p.translate(-1, -1);
		if (pos == 0 && p.getX() >= board.length - ship.getLength()) {
			return false;
		} else if (pos == 1 && p.getY() >= board.length - ship.getLength()) {
			return false;
		}
		
		for (int i = 0; i < ship.getLength(); i++) {
			for (int j = p.getY(); j < p.getY() + 3; j++) {
				for (int k = p.getX(); k < p.getX() + 3; k++) {
					try {
						if (board[j][k] != symbol) {
							return false;
						}
					} catch (IndexOutOfBoundsException e) {}
				}
			}
			increment(p, pos);
		}
		p.setX(x);
		p.setY(y);
		return true;
	}
	
	private void increment(Point p, int pos) {
		if (pos == 0) {
			p.translate(1, 0);
		} else {
			p.translate(0, 1);
		}
	}

	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = symbol;
			}
		}
	}
	
	@Override
	public String toString() {
		String output = "  0 1 2 3 4 5 6 7 8 9\n";
		int number = 0;
		for (char[] row : board) {
			output += number + " ";
			for (char c : row) {
				output += c + " ";
			}
			output += "\n";
			number++;
		}
		return output;
	}
	
	
	
}
