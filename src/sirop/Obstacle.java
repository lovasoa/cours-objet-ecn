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
        
        private Point2D positionObs;
        /**Create a obstacle*/
        public Obstacle(Point2D PositionObs){
            this.positionObs=PositionObs;
        }
        /**@print the position*/
        public void AffichageObs(){
            System.out.println("La position de l'obstacle est ["+positionObs.getX()
            +","+positionObs.getY()+"].");
        }
        /**@return the type of the obstacle*/
        public String getType (){
            return "Obstacle sans type.";}
        
        public Point2D getPosition (){
            return this.positionObs;}
        
        /**@return the information of the obstacle*/
        public String toString(){
            String res="C'est un "+this.getType()+"La position de l'obstacle est ["+positionObs.getX()
            +","+positionObs.getY()+"].";
            return res;
        }
        
    
}
