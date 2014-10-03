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
public class Obstacle extends ElementJeu {        
  /**Create a obstacle*/
  public Obstacle(Point2D PositionObs, PlateauJeu plateau){
      super(PositionObs, plateau);
  }

  /**@print the position*/
  public void AffichageObs(){
      System.out.println("La position de l'obstacle est ["+this.getPosition().getX()
      +","+this.getPosition().getY()+"].");
  }
  /**@return the type of the obstacle*/
  public String getType (){
      return "Obstacle sans type.";}

  /**@return the information of the obstacle*/
  public String toString(){
      String res="C'est un "+this.getType()+"La position de l'obstacle est ["+this.getPosition().getX()
      +","+this.getPosition().getY()+"].";
      return res;
  }
}
