/*
 * @author: lovasoa
 */

package sirop;

/*
 * Représente un obstacle qui peut rendre de l'énergie
 * ou de la santé à un robot
 **/

public abstract class Bonus extends Obstacle {
  private int gainSante = 0;
  private int gainEnergie = 0;

  public Bonus(Point2D pos) {
    super(pos);
  }

}
