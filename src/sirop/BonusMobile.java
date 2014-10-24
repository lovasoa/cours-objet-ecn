/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author zhaoshuli
 */
public class BonusMobile extends Bonus {

  /**
   * Create a mobile bonus
   */
  public BonusMobile(int pointsSante, int pointsEnergie, PlateauJeu plateau, Point2D PositionMobile) {
    super(pointsSante, pointsEnergie, plateau, PositionMobile);
  }
  
  /**
   * @return the type of the bonus
   */
  public String getType() {
    return "BonusMobile";
  }

  /**
   * Déplacer le bonus *
   */
  public boolean deplacer(Point2D vect) {
    this.getPosition().deplacer(vect);
    return true;
  }
}
