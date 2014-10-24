/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;

/**
 *
 * @author zhaoshuli
 */
public class BonusMobile extends Bonus{
    private Icon iconBonusMobile;
    
    /**Create a mobile bonus*/
    public BonusMobile(Point2D PositionMobile, int pointsSante, int pointsEnergie, PlateauJeu plateau){
        super(pointsSante, pointsEnergie, plateau, PositionMobile);
        iconBonusMobile = new Icon("/resources/powerup.png", "iconBonusMobile");
        plateau.getBoard().displayGameElement(PositionMobile, iconBonusMobile, iconBonusMobile.getIconName() , "Creer un "+this.getType());
    }
    
    /**@return the type of the bonus*/
        public String getType (){
            return "BonusMobile";}
    /** Déplacer le bonus **/    
        public boolean deplacer(Point2D vect){
              this.getPosition().deplacer(vect);
              return true;
        }
}
