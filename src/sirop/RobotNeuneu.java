
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotNeuneu extends Robot{
    /** Créer un RobotNeuneu **/
        public RobotNeuneu(String name, PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
        public RobotNeuneu(PlateauJeu plateau){
            super(plateau);
        }
    
        public String getType(){return "RobotNeuneu";}
    
}
