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
  private final static int BORNE_GAIN_ENERGIE = 10;

  public Bonus(Point2D pos) {
    super(pos);
    this.pointsEnergie = BORNE_MAX_ENERGIE;
    this.gainEnergie = BORNE_GAIN_ENERGIE;
  }
}
