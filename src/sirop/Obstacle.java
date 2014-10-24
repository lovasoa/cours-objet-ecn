/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sirop;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author zhaoshuli
 */

public abstract class Obstacle extends ElementJeu {        
  private Icon iconObstacle;
  private GUIBoard board;
  
  /**Create a obstacle*/
  public Obstacle(Point2D PositionObs, PlateauJeu plateau){
      super(PositionObs, plateau);
      iconObstacle.createImageIcon("/resources/obstacle.png", "C'est l'image de obstacle.");
      iconObstacle.setIconName("IconObstacle");
      board.displayGameElement(PositionObs, iconObstacle,iconObstacle.getIconName() , "Creer un "+this.getType());
  }
  
    /**Create a obstacle*/
  public Obstacle(PlateauJeu plateau){
      super(plateau);
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
  
  public void writeObject(ObjectOutputStream out) throws IOException {
    this.getPosition().writeObject(out);
  }
  
  public void readObject(ObjectInputStream in) throws IOException {
    Point2D p = new Point2D(0,0);
    p.readObject(in);
    this.setPosition(p);
  }
}
