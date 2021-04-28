package me.jonmuxu.battleshipgame.game;

public class GameManager {

	private static int difficulty = 0;
	private static int money;
	private static int rewardPerGame;
	private static int boardSize;
	private static int shipSlots;
	private static int maximumShipSlots;
	private static char symbol = '~';

	public static void setDefaults() {
		switch (difficulty) {
			case 0:
				GameManager.money = 3000;
				GameManager.rewardPerGame = 500;
				GameManager.boardSize = 10;
				GameManager.shipSlots = 3;
				GameManager.maximumShipSlots = 5;
				break;
	
			case 1:
				GameManager.money = 2500;
				GameManager.rewardPerGame = 200;
				GameManager.boardSize = 15;
				GameManager.shipSlots = 2;
				GameManager.maximumShipSlots = 5;
				break;
	
			case 2:
				GameManager.money = 1000;
				GameManager.rewardPerGame = 100;
				GameManager.boardSize = 20;
				GameManager.shipSlots = 1;
				GameManager.maximumShipSlots = 3;
				break;
		}
	}

	public static int getDifficulty() {
		return difficulty;
	}

	public static int getMoney() {
		return money;
	}

	public static int getRewardPerGame() {
		return rewardPerGame;
	}

	public static int getBoardSize() {
		return boardSize;
	}

	public static int getShipSlots() {
		return shipSlots;
	}

	public static int getMaximumShipSlots() {
		return maximumShipSlots;
	}

	public static char getSymbol() {
		return symbol;
	}

	public static void setDifficulty(int difficulty) {
		GameManager.difficulty = difficulty;
	}

	public static void setMoney(int money) {
		GameManager.money = money;
	}

	public static void setRewardPerGame(int rewardPerGame) {
		GameManager.rewardPerGame = rewardPerGame;
	}

	public static void setBoardSize(int boardSize) {
		GameManager.boardSize = boardSize;
	}

	public static void setShipSlots(int shipSlots) {
		GameManager.shipSlots = shipSlots;
	}

	public static void setMaximumShipSlots(int maximumShipSlots) {
		GameManager.maximumShipSlots = maximumShipSlots;
	}

	public static void setSymbol(char symbol) {
		GameManager.symbol = symbol;
	}

}
