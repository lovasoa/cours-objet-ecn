package sirop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

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
    robots = new ArrayList<>(0);
    obstacles = new ArrayList<>(0);
    bonuses = new ArrayList<>(0);
  }
  
  public void ajouterRobotNeuneu(String nom) {
    Robot robot = new RobotNeuneu(nom, this);
    robots.add(robot);
  }
  
  public void tourDeJeu() {
    boolean continuer = true;
    Scanner scanner = new Scanner(System.in);

    while (continuer){
      
      System.out.println("Nouveau tour de jeu:");
      System.out.println(" robots (" + robots.size() +"): ");
      for (Robot robot : this.robots) {
        System.out.println("- " + robot);
      }

      System.out.println(" obstacles (" + obstacles.size() +"): ");
      for (Obstacle obstacle : this.obstacles) {
        System.out.println("- " + obstacle);
      }
      
      System.out.println(" bonuses (" + bonuses.size() +"): ");
      for (Bonus bonus : this.bonuses) {
        System.out.println("- " + bonus);
      }
      
      System.out.println("Voulez-vous continuer? (oui/non) ");
      continuer = scanner.nextLine().trim().equalsIgnoreCase("oui");
    }
  }
}
