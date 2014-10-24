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
  private Icon iconBorneSante;
  
/**Create a mobile bonus*/
  public BorneSante(PlateauJeu plateau) {
    super(BORNE_MAX_SANTE, 0, plateau);
    iconBorneSante = new Icon("/resources/eco_green_tree.png", "C'est l'image de borne sante.");
    iconBorneSante.setIconName("iconBorneSante");
    plateau.getBoard().displayGameElement(this.getPosition(), iconBorneSante,iconBorneSante.getIconName() , "Creer un "+this.getType());
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
