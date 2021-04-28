package me.jonmuxu.battleshipgame.entities;


public class Shop {

	private static Ship[] shipList = {new Ship("Carrier", 'C', 5, 20, 750),
									  new Ship("BattleShip",'B', 4, 30, 1000),
									  new Ship("Cruiser", 'R', 4, 40, 2200),
									  new Ship("Submarine",'S', 3, 40, 2500),
									  new Ship("Destroyer", 'D', 2, 60, 3000)};
	
	
	
	public static void buyShip(Player p, String name) {
		for (Ship ship : shipList) {
			if (ship.getName().equalsIgnoreCase(name)) {
				if (p.getBalance() >= ship.getPrice()) {
					p.removeBalance(ship.getPrice());
					p.getShipList().add(new Ship(ship));
					System.out.println("Succesfully bought " + ship.getName() + "!");
					return;
				} else {
					System.out.println("You cannot afford that");
				}
			} else {
				System.out.println("That ship doesn't exist in the shop");
			}
		}
	}
	
	public static void sellShip(Player p, String name) {
		for (Ship ship : shipList) {
			if (ship.getName().equalsIgnoreCase(name)) {
				p.addBalance(ship.getPrice() - (20 - ship.getPrice()) * 100); // percentage
				p.getShipList().remove(ship);
				return;
			}
		}
		System.out.println("That ship doesn't exist in your inventory");
	}
	
	public static Ship[] getShipList() {
		return shipList;
	}
	
	
}
