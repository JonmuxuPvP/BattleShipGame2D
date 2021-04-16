package me.jonmuxu.battleshipgame.entities;

import java.util.Random;

public class Point {

	private Random rnd;
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.rnd = new Random();
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this.rnd = new Random();
		this.x = 0;
		this.y = 0;
	}
	
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}
	
	public void random(int range) {
		x = rnd.nextInt(range);
		y = rnd.nextInt(range);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[x = " + this.x + ", y = " + this.y + "]";
	}
	
}
