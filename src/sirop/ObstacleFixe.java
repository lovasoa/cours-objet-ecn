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
public class ObstacleFixe extends Obstacle {

  /**
   * Create a fixed obstacle
   */
  public ObstacleFixe(PlateauJeu plateau) {
    super(plateau);
  }

  /**
   * @return the type of the obstacle
   */
  public String getType() {
    return "ObstacleFixe.";
  }

}
