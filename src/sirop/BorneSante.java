package sirop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author lovasoa
 **/

/**
 * Une borne d'énergie qui possède une quatité limitée d'énergie
 * et peut l'utiliser pour recharger des robots
 */
public class BorneSante extends Bonus {
  private final static int BORNE_MAX_SANTE = 100;
/**Create a mobile bonus*/
  public BorneSante(Point2D pos, PlateauJeu plateau) {
    super(pos, BORNE_MAX_SANTE, 0, plateau);
  }
  /**@return the type of the bonus*/
  public String getType(){
    return"BorneSante";}
  
  public void writeObject(ObjectOutputStream out) throws IOException {
    super.writeObject(out);
    out.writeInt(this.getPointsSante());
  }
  
  public void readObject(ObjectInputStream in) throws IOException {
    super.readObject(in);
    this.setPointsSante(in.readInt());
  }
}
