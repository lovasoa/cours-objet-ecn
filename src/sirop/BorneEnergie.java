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
/**Create a mobile bonus*/
  public BorneEnergie(Point2D pos, PlateauJeu plateau) {
    super(0, BORNE_MAX_ENERGIE, plateau, pos);
  }
  
   public BorneEnergie(PlateauJeu plateau) {
    super(0, BORNE_MAX_ENERGIE ,plateau);
  }
  
  /**@return the type of the bonus*/
  public String getType(){
    return"BorneEnergie";}
}
