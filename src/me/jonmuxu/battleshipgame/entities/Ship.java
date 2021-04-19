package me.jonmuxu.battleshipgame.entities;

public class Ship {

	private String name;
	private char letter;
	private int length;
	private int health;
	private int ammo;
	private int maxAmmo;

	public Ship(String name, char letter, int length, int maxAmmo) {
		super();
		this.name = name;
		this.letter = letter;
		this.length = length;
		this.health = length;
		this.ammo = maxAmmo;
		this.maxAmmo = maxAmmo;
	}

	public void hit() {
		health--;
	}

	public void refillAmmo() {
		if (ammo > maxAmmo) {
			ammo = maxAmmo;
		}
	}

	public void shoot() {
		ammo--;
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

	public int getAmmo() {
		return ammo;
	}

	public int getMaxAmmo() {
		return maxAmmo;
	}

	@Override
	public String toString() {
		return "[" + this.name + ", " + this.ammo + "]";
	}

}
