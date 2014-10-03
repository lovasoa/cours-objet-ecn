
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotEnergivore extends Robot{
        public RobotEnergivore(String name,PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
        
        public String getType(){return "RobotEnergivore";}
    
}
