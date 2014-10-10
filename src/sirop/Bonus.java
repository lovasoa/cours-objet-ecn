/*
 * @author: lovasoa
 */

package sirop;

/*
 * Représente un obstacle qui peut rendre de l'énergie
 * ou de la santé à un robot
 **/

public abstract class Bonus extends Obstacle {
  private int pointsSante = 0;
  private int gainSante = 0;

  private int pointsEnergie = 0;
  private int gainEnergie = 0;
  
/** Créer un bonus dans platuea **/
  public Bonus(Point2D pos, int pointsSante, int pointsEnergie, PlateauJeu plateau) {
    super(pos, plateau);
    this.pointsEnergie = pointsEnergie;
    this.gainEnergie = pointsEnergie / 10;
    this.pointsSante = pointsSante;
    this.gainSante = pointsSante / 10;
  }
/** Donner la santé au robot s'il en reste encore**/
  private boolean appliquerBonusSante(Robot robot) {
    if (this.pointsSante >= this.gainSante
        && robot.reparer(this.pointsSante)) {
        this.pointsSante -= this.gainSante;
        return true;
    }
    return false;
  }
/** Donner l'énergie au robot s'il en reste encore**/
  private boolean appliquerBonusEnergie(Robot robot) {
    if (this.pointsEnergie >= this.gainEnergie
        && robot.recharger(this.pointsEnergie)) {
        this.pointsEnergie -= this.gainEnergie;
        return true;
    }
    return false;
  }
/** Donner l'énergie et la santé au robot**/
  public boolean appliquerBonus(Robot robot) {
    return this.appliquerBonusEnergie(robot) && this.appliquerBonusEnergie(robot);
  }
  public String getType(){
    return "Bonus sans type";}
  /** Redifinir toString pour afficher tous les informations**/
  public String toString(){
    String res="C'est un "+this.getType()+"\nLa position de le bonus est ["+this.getPosition().getX()
            +","+this.getPosition().getY()+"]."+"\nLe bonus du pointEnergie est"+this.gainEnergie
            +"\nLe bonus du pointSante est"+this.gainSante;
            return res;}

}
