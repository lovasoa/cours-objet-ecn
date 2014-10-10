
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotCombattant extends Robot{
    //creat a RobotCombattant
        public RobotCombattant(String name,PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
    //return its type
        public String getType(){return "RobotCombattant";}
}
