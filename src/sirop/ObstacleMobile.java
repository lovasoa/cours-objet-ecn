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
public class ObstacleMobile extends Obstacle {
    /**Create a mobile obstacle*/
    public ObstacleMobile(Point2D PositionMobile){
        super(PositionMobile);
    }
    
    /**@return the type of the obstacle*/
        public String getType (){
            return "ObstaclMobile.";}
            
    
}
