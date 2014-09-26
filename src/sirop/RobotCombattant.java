
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotCombattant extends Robot{
    
        public RobotCombattant(String name,PlateauJeu plateau){
            super(name,plateau);
        }
    
        public String getType(){return "RobotCombattant";}
}
