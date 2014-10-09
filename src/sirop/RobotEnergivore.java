
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotEnergivore extends Robot{
    //creat a RobotEnergivore
    public RobotEnergivore(String name,PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
    //return its type    
        public String getType(){return "RobotEnergivore";}
    
}
