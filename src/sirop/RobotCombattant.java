
package sirop;

/**
 *
 * @author zhaoshuli
 */
public class RobotCombattant extends Robot{
    /** Créer un RobotCombattant **/
        public RobotCombattant(String name,PlateauJeu plateau, Point2D pos){
            super(name,plateau,pos);
        }
        public RobotCombattant(PlateauJeu plateau){
            super(plateau);
        }

        public String getType(){return "RobotCombattant";}
}
