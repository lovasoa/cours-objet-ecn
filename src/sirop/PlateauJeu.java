package sirop;
/**
 * @author lovasoa
 */

/**
 * Décrit un plateau de jeu
 */
public class PlateauJeu {
  private int[] dimensions = {100,100}; 
  private Robot robot;
  private Obstacle obstacle;
  private Bonus bonus;

  public PlateauJeu(int largeur, int hauteur) {
    this.dimensions[0] = largeur;
    this.dimensions[1] = hauteur;
  }
}
