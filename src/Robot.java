/**
 * Représente un robot
 */
public class Robot {
	private String name;
	private Point2D position;
	private int energy;
	private int health;

	/** Crée un robot */
	public Robot(String name) {
		this.name = name;
		this.position = new Point2D(0,0);
		this.energy = 100;
		this.health = 100;
	}

	/** @param health new health value */
	public void setHealth(int health) {this.health = health;}	

	/** @param energy new energy value */
	public void setEnergy(int energy) {this.energy = energy;}	

	/** @param position new position*/
	public void setPosition(Point2D position) {this.position = position;}	

	/** @return The level of health of the robot*/
	public int getHealth() {return this.health;}	

	/** @return the energy of the robot*/
	public int getEnergy() {return this.energy;}	

	/** @return the position of the robot*/
	public Point2D getPosition() {return this.position;}	
}
