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
   public BorneEnergie(PlateauJeu plateau) {
    super(0, BORNE_MAX_ENERGIE ,plateau);
    iconBorneEnergie = new Icon("/resources/eco_green_energy.png", "iconBorneEnergie");
    plateau.getBoard().displayGameElement(this.getPosition(), iconBorneEnergie, iconBorneEnergie.getIconName() , "Creer un "+this.getType());
  }
  
  /**@return the type of the bonus*/
  public String getType(){
    return"BorneEnergie";}
}
