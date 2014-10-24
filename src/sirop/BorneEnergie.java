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
  private Icon iconBorneEnergie;
  private GUIBoard board;
  
/**Create a mobile bonus*/
  public BorneEnergie(Point2D pos, PlateauJeu plateau) {
<<<<<<< Updated upstream
    super(0, BORNE_MAX_ENERGIE, plateau, pos);
  }
  
   public BorneEnergie(PlateauJeu plateau) {
    super(0, BORNE_MAX_ENERGIE ,plateau);
=======
    super(pos, 0, BORNE_MAX_ENERGIE, plateau);
    iconBorneEnergie.createImageIcon("/resources/eco_green_energy.png", "C'est l'image de borne energie.");
    iconBorneEnergie.setIconName("iconBorneEnergie");
    board.displayGameElement(pos, iconBorneEnergie,iconBorneEnergie.getIconName() , "Creer un "+this.getType());
>>>>>>> Stashed changes
  }
  
  /**@return the type of the bonus*/
  public String getType(){
    return"BorneEnergie";}
}
