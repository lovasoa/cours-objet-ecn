/**
 * Représente un robot
 */
public class Robot {
	private String name;
	private Point2D pos;
	private int energy;
	private int health;

	/** Crée un robot */
	public Robot(String name) {
		this.name = name;
		this.pos = new Point2D(0,0);
		this.energy = 100;
		this.health = 100;
	}

	/** @param health new health value */
	public void setHealth(int health) {this.health = health;}	

	/** @param energy new energy value */
	public void setEnergy(int energy) {this.energy = energy;}	
}
