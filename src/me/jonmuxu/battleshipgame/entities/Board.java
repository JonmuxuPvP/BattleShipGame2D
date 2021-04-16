package me.jonmuxu.battleshipgame.entities;

public class Board {

	private char[][] board;
	private char symbol;
	
	public Board(int width, int height, char symbol) {
		this.board = new char[width][height];
		this.symbol = symbol;
		fillBoard();
	}
	
	private void fillBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = symbol;
			}
		}
	}
	
	
	
}
