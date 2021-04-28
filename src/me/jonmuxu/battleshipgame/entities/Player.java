package me.jonmuxu.battleshipgame.entities;

import me.jonmuxu.battleshipgame.game.GameManager;

public class Player extends CPU {

	private Board enemyBoard;
	private int balance;
	private int shipSlots;
	private int maxShipSlots;
	private int defeatedCPUs;
	
	public Player(String name) {
		super(name);
		this.enemyBoard = new Board(GameManager.getBoardSize(), GameManager.getSymbol());
		this.balance = GameManager.getMoney();
		this.shipSlots = GameManager.getShipSlots();
		this.maxShipSlots = GameManager.getMaximumShipSlots();
		this.defeatedCPUs = 0;
	}
	
	public void addBalance(int amount) {
		balance += amount;
	}
	
	public void removeBalance(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.balance + ", " + this.shipList;
	}
	
	
	
	
}
