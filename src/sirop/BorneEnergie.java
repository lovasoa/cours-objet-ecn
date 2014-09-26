package sirop;
/**
 * @author lovasoa
 **/

/**
 * Une borne d'énergie qui possède une quatité limitée d'énergie
 * et peut l'utiliser pour recharger des robots
 */
public class BorneEnergie extends Bonus {
  private final static int BORNE_MAX_ENERGIE = 100;

  public BorneEnergie(Point2D pos, PlateauJeu plateau) {
    super(pos, 0, BORNE_MAX_ENERGIE, plateau);
  }
  public String getType(){
    return"BorneEnergie";}
}
