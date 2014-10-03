package sirop;

import java.util.List;
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
  private int largeur = 100;
  private int hauteur = 100;
  private ArrayList<Robot> robots;
  private ArrayList<Obstacle> obstacles;
  private ArrayList<Bonus> bonuses;

  public PlateauJeu(int largeur, int hauteur) {
    this.largeur = largeur;
    this.hauteur = hauteur;
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
  public boolean horsPlateau(Point2D point){
    return point.getX()>this.largeur || point.getY()>this.hauteur;
  }
  
  public boolean caseLibre(Point2D point) {
    for (Robot robot : this.robots) {
        if (robot.getPosition().equals(point)) return false;
    }
    for (Obstacle obstacle : this.obstacles) {
      if (obstacle.getPosition().equals(point)) {
        return false;
      }
    }
    for (Bonus bonus : this.bonuses) {
      if (bonus.getPosition().equals(point)) {
        return false;
      }
    }
    return true;
  }
  
  public List<Point2D> casesLibresAutourDe (Point2D reference){
    List<Point2D> cases = new ArrayList<>();
    for (int dx=-1; dx<=1; dx++) {
      for (int dy=-1; dy<=1; dy++) {
        if (dx==0 && dy==0) continue;
        Point2D p = new Point2D(reference.getX()+dx,reference.getY()+dy);
        if (caseLibre(p)) {
          cases.add(p);
        }
      }
    }
    return cases;
  }

}
