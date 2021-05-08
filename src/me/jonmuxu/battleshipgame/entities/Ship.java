package me.jonmuxu.battleshipgame.entities;

public class Ship {

	private String name;
	private char letter;
	private int length;
	private int health;

	public Ship(String name, char letter, int length) {
		this.name = name;
		this.letter = letter;
		this.length = length;
		this.health = length;
	}

	public void hit() {
		health--;
	}

	public String getName() {
		return name;
	}

	public char getShipLetter() {
		return letter;
	}

	public int getLength() {
		return length;
	}

	public int getHealth() {
		return health;
	}

	@Override
	public String toString() {
		return this.name;
	}

	

}
