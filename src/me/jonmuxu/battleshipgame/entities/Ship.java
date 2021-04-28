package me.jonmuxu.battleshipgame.entities;

public class Ship {

	private String name;
	private char letter;
	private int length;
	private int health;
	private int ammo;
	private int maxAmmo;
	private int price;

	public Ship(String name, char letter, int length, int maxAmmo, int price) {
		this.name = name;
		this.letter = letter;
		this.length = length;
		this.health = length;
		this.ammo = maxAmmo;
		this.maxAmmo = maxAmmo;
		this.price = price;
	}
	
	public Ship(Ship s) {
		this.name = s.getName();
		this.letter = s.getShipLetter();
		this.length = s.getLength();
		this.health = s.getHealth();
		this.ammo = s.getAmmo();
		this.maxAmmo = s.getMaxAmmo();
		this.price = s.getPrice();
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
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "[" + this.name + ", " + this.ammo + "]";
	}

	

}
