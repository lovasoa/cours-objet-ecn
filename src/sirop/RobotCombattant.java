
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotCombattant extends Robot{
    
        public RobotCombattant(String name,PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
    
        public String getType(){return "RobotCombattant";}
}
