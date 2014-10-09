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
//creat a PlateauJeu
  public PlateauJeu(int largeur, int hauteur) {
    this.largeur = largeur;
    this.hauteur = hauteur;
    robots = new ArrayList<>(0);
    obstacles = new ArrayList<>(0);
    bonuses = new ArrayList<>(0);
  }
//add a RobotNeuneu  
  public void ajouterRobotNeuneu(String nom, Point2D pos) {
    Robot robot = new RobotNeuneu(nom, this, pos);
    robots.add(robot);
  }
//print out the elements of robot and ask if creat more  
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
  
  /**
   * Permet de savoir si une case est libre ou pas
   * @param point Une case
   * @return true si la case est dans le plateau et qu'il n'y a rien dessus
   */
  public boolean caseLibre(Point2D point) {
    if (this.horsPlateau(point)) {
      return false;
    }
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
  //return true if the cases aroud the case are empty
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