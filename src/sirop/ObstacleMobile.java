/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class ObstacleMobile extends Obstacle implements Movable{
    /**Create a mobile obstacle*/
    public ObstacleMobile(Point2D PositionMobile, PlateauJeu plateau){
        super(PositionMobile, plateau);
    }
    
    /**@return the type of the obstacle*/
        public String getType (){
            return "ObstaclMobile.";}
        
        public boolean deplacer(Point2D vect){
            if (this.deplacementAutorise(vect)) {
              this.getPosition().deplacer(vect);
              return true;
            }
            return false;
        }
        
        public boolean deplacementAutorise(Point2D vect) {
          return (this.getPlateau().caseLibre(vect)) &&
                  (vect.getX() == 0 || vect.getY() == 0);
        }
            
    
}
