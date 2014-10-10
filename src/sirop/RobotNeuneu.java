
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotNeuneu extends Robot{
    //creat a RobotNeuneu
        public RobotNeuneu(String name, PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
    //return its type    
        public String getType(){return "RobotNeuneu";}
    
}
