/**
 * Représente un robot
 */
public class Robot {

  public static int ROBOT_MAX_ENERGIE = 150;
  public static int ROBOT_MAX_SANTE = 200;
  public static int ROBOT_DEFAUT_ENERGIE = 100;
  public static int ROBOT_DEFAUT_SANTE = 100;

	private String name;
	private Point2D position;
	private int energy = ROBOT_DEFAUT_ENERGIE;
	private int health = ROBOT_DEFAUT_SANTE;

	/** Crée un robot */
	public Robot(String name) {
		this.name = name;
		this.position = new Point2D(0,0);
	}

	/** @param health new health value */
	public boolean setHealth(int health) {
    if (health > ROBOT_MAX_ENERGIE) {return false;}
    this.health = health;
    return true;
  }

	/** @param energy new energy value */
	public boolean setEnergy(int energy) {
    if (energy > ROBOT_MAX_ENERGIE) {return false;}
    this.energy = energy;
    return true;
  }	

	/** @param position new position*/
	public void setPosition(Point2D position) {this.position = position;}	

	/** @return The level of health of the robot*/
	public int getHealth() {return this.health;}	

	/** @return the energy of the robot*/
	public int getEnergy() {return this.energy;}	

	/** @return the position of the robot*/
	public Point2D getPosition() {return this.position;}	

  /** Déplace le robot */
	public boolean move(Point2D vect) {
		this.getPosition().move(vect);
		return true;
	}

  /** Redonne de l'énergie au robot
   * @param energy L'énergie à ajouter au robot
   * @return true si le robot a bien été rechargé*/
  public boolean recharger(int energy) {
    return this.setEnergy(this.getEnergy() + energy);
  }

  /** Redonne de la vie au robot */
  public boolean reparer(int health) {
    return this.setHealth(this.getHealth() + health);
  }

  /** Dépense de l'énergie du robot 
   * @return true si l'énergie a pu être dépensée*/
  public boolean depenserEnergie(int energy) {
    return this.setEnergy(this.getEnergy() - energy);
  }
}
