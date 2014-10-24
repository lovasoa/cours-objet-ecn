package sirop;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lovasoa
 */

/**
 * Décrit un plateau de jeu
 */
public class PlateauJeu implements Serializable {
  private int largeur = 100;
  private int hauteur = 100;

  private ListeElementsJeu listeElementsJeu;
  private GUIBoard monInterface; 
  
/** Créer un PlateauJeu **/
  public PlateauJeu(int largeur, int hauteur) {
    this.largeur = largeur;
    this.hauteur = hauteur;
    this.listeElementsJeu = new ListeElementsJeu();
  }

  public void ajouterRobotNeuneu(String nom, Point2D pos) {
    Robot robot = new RobotNeuneu(nom, this, pos);
    this.listeElementsJeu.ajoutRobot(robot);
  }
/** Afficher tous les éléments et demander si le utilisateur veux créer plus **/ 
  public void tourDeJeu() {
    boolean continuer = true;
    Scanner scanner = new Scanner(System.in);

    while (continuer){
      
      System.out.println("Nouveau tour de jeu:");
      System.out.println(" Elements de jeu (" + this.listeElementsJeu.size() +"): ");
      for (ElementJeu elem : this.listeElementsJeu) {
        System.out.println(elem);
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
    for (ElementJeu elem : this.listeElementsJeu) {
      if (elem.getPosition().equals(point)) {
        return false;
      }
    }
    return true;
  }
  
  /** Retourne true si les case autour sont libres**/
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
  
 public void writeObject(ObjectOutputStream out) throws IOException {
   out.writeUTF("Largeur");
   out.writeInt(this.largeur);
   out.writeUTF("Hauteur");
   out.writeInt(this.hauteur);
   this.listeElementsJeu.writeObject(out);
 }

  /**
   * Cree l'interface avec les dimensions du plateau
   * @param l : largeur de la GUI (boutons)
   * @param h : hauteur de la GUI (boutons)
   */
  public void creerGUI(int l, int h) {
    this.monInterface = new GUIBoard(l, h);
    this.monInterface.setVisible(true);
  }
    
}