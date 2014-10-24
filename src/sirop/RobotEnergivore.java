
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotEnergivore extends Robot{
    /** Créer un RobotEnergivore **/
    public RobotEnergivore(String name,PlateauJeu plateau, Point2D pos){
        super(name,plateau,pos);
    }
    /** Créer un RobotEnergivore **/
    public RobotEnergivore(PlateauJeu plateau){
        super(plateau);
    }
       
    public String getType(){return "RobotEnergivore";}
    
}
