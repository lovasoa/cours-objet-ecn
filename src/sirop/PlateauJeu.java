package sirop;

import java.util.ArrayList;

/**
 * @author lovasoa
 */

/**
 * Décrit un plateau de jeu
 */
public class PlateauJeu {
  private int[] dimensions = {100,100}; 
  private ArrayList<Robot> robots;
  private ArrayList<Obstacle> obstacles;
  private ArrayList<Bonus> bonuses;

  public PlateauJeu(int largeur, int hauteur) {
    this.dimensions[0] = largeur;
    this.dimensions[1] = hauteur;
  }
  
  public void ajouterRobot(Robot robot) {
    robots.add(robot);
  }
  
  public void tourDeJeu() {
    
  }
}
