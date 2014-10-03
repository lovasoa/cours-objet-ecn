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
  
  public ElementJeu (Point2D pos, PlateauJeu plateau) {
    this.position = pos;
    this.plateau = plateau;
  }
  
  public Point2D getPosition() {
    return this.position;
  }
  
  public void setPosition(Point2D position) {
    this.position = position;
  }
  
  public PlateauJeu getPlateau() {
    return this.plateau;
  }
}
