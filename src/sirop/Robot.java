package sirop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Représente un robot
 * @author lovasoa
 */
public class Robot extends ElementJeu implements Movable, Serializable{

  public static final int ROBOT_MAX_ENERGIE = 150;
  public static final int ROBOT_MAX_SANTE = 200;
  public static final int ROBOT_DEFAUT_ENERGIE = 100;
  public static final int ROBOT_DEFAUT_SANTE = 100;

  private String name;
  private int energy = ROBOT_DEFAUT_ENERGIE;
  private int health = ROBOT_DEFAUT_SANTE;
  private int cout_deplacement = 1;
  private static int nbre_instances = 0;
  private PlateauJeu plateau;
  private Icon iconRobot;
  private GUIBoard board;

  /** Créer un robot */
  public Robot(String name, PlateauJeu plateau, Point2D position) {
    super(position, plateau);

    Robot.nbre_instances ++;
    this.setName(name);
    this.plateau=plateau;
    iconRobot = new Icon("/resources/robot.png", "iconRobot");
    plateau.getBoard().displayGameElement(position, iconRobot, iconRobot.getIconName() , "Creer un "+this.getType());
    
  }

  /** Créer un robot */
  public Robot(PlateauJeu plateau) {
    super(plateau);

    Robot.nbre_instances ++;
    this.setName("AnonymousRobot");
    this.plateau = plateau;
  }

  public void setName(String name) {
    this.name = name.replace(' ', '_').replace('\t', '_');
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

	/** @return The level of health of the robot*/
	public int getHealth() {return this.health;}	

	/** @return the energy of the robot*/
	public int getEnergy() {return this.energy;}

	
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
        
  /** @return the type of the robot*/
  public String getType(){return"RobotSimple";}
  
   /** @return the information of the robot*/
  public String toString(){
    String res="Je m'appelle "+ name + ", je suis un robot de type " + this.getType() + 
      ", je possede "+ energy +" points d'energie, "+health+ 
      " points de vie et je me trouve en position ["+this.getPosition().getX()+","+this.getPosition().getY()+"].";
    return res;}

  /** @print the information of the robot*/
  public void afficherRobot(){
      
      System.out.println(this.toString());   
  
    }

    /** Déplacer le robot et lui fait perdre de l'énergie*/
  @Override
    public boolean deplacementAutorise(Point2D vect){
        return (vect.getX() <= 1 && 
                vect.getX() >= -1 &&
                vect.getY() <= 1 &&
                vect.getY() >= -1);
    }
    public boolean deplacer(Point2D vect) {
      if(deplacementAutorise(vect)){
        this.getPosition().deplacer(vect);
        this.depenserEnergie(this.cout_deplacement);
        this.depenserEnergie(1);
		return true;
      }
      else return false;
        //To change body of generated methods, choose Tools | Templates.
    }
    
  public void writeObject(ObjectOutputStream out) throws IOException {
    out.writeUTF(name);
    this.getPosition().writeObject(out);
    out.writeInt(health);
    out.writeInt(energy);
  }
  
  public void readObject(ObjectInputStream in) throws IOException{
    this.name = in.readUTF();
    
    Point2D p = new Point2D(0,0);
    p.readObject(in);
    this.setPosition(p);
    
    this.health = in.readInt();
    this.energy = in.readInt();
  }
  
  
}

