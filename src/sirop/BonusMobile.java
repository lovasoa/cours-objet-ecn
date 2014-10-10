/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class BonusMobile extends Bonus{
    /**Create a mobile bonus*/
    public BonusMobile(Point2D PositionMobile, int pointsSante, int pointsEnergie, PlateauJeu plateau){
        super(PositionMobile, pointsSante, pointsEnergie, plateau);
    }
    
    /**@return the type of the bonus*/
        public String getType (){
            return "BonuslMobile.";}
    /** Déplacer le bonus **/    
        public boolean deplacer(Point2D vect){
              this.getPosition().deplacer(vect);
              return true;
        }
        
    
}
