/*
 * @author: lovasoa
 */

package sirop;

/*
 * Représente un obstacle qui peut rendre de l'énergie
 * ou de la santé à un robot
 **/

public abstract class Bonus extends Obstacle {
  private int pointsSante = 100;
  private int gainSante = 0;

  private int pointsEnergie = 100;
  private int gainEnergie = 0;

  public Bonus(Point2D pos) {
    super(pos);
  }

  private boolean appliquerBonusSante(Robot robot) {
    if (this.pointsSante >= this.gainSante
        && robot.reparer(this.pointsSante)) {
        this.pointsSante -= this.gainSante;
        return true;
    }
    return false;
  }

  private boolean appliquerBonusEnergie(Robot robot) {
    if (this.pointsEnergie >= this.gainEnergie
        && robot.recharger(this.pointsEnergie)) {
        this.pointsEnergie -= this.gainEnergie;
        return true;
    }
    return false;
  }

  public boolean appliquerBonus(Robot robot) {
    return this.appliquerBonusEnergie(robot) && this.appliquerBonusEnergie(robot);
  }

}
