/* ce projet est libre; sous les temes de la license LGPLv3
*/
package sirop;

/**
 *
 * @author olojkine
 */


public abstract class ElementJeu {
  private Point2D position;
  private PlateauJeu plateau;
  //creater an ElementJeu
  public ElementJeu (Point2D pos, PlateauJeu plateau) {
    this.position = pos;
    this.plateau = plateau;
  }
  //return the position
  public Point2D getPosition() {
    return this.position;
  }
  //set the position
  public void setPosition(Point2D position) {
    this.position = position;
  }
  //return the plateau
  public PlateauJeu getPlateau() {
    return this.plateau;
  }
}
