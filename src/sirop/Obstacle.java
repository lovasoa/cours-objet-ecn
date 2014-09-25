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
public class Obstacle {
        
        private Point2D PositionObs;
        public Obstacle(Point2D PositionObs){
            this.PositionObs=PositionObs;
        }
        public void AffichageObs(){
            System.out.println("La position de l'obstacle est ["+PositionObs.getX()
            +","+PositionObs.getY()+"].");
        }
        
    
}
