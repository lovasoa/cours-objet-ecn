/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */

package sirop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author olojkine
 */
public class ListeElementsJeu implements Iterable{

  private ArrayList<Robot> robots;
  private ArrayList<Obstacle> obstacles;
  private String filter;
  
  public ListeElementsJeu() {
    this.robots = new ArrayList<>();
    this.obstacles = new ArrayList<>();
    this.filter = null;
  }
  
  @Override
  public Iterator<ElementJeu> iterator() {
    List<List<ElementJeu>> elems = new ArrayList<>();
    elems.add((ArrayList<ElementJeu>)(ArrayList<?>) this.robots);
    elems.add((ArrayList<ElementJeu>)(ArrayList<?>) this.obstacles);
    String filter = this.filter;
    this.filter = null;
    return new IteratorOfLists<ElementJeu>(elems);
  }
  
  public void ajoutRobot(Robot robot) {
    this.robots.add(robot);
  }
  
  public void ajoutObstacle(Obstacle obstacle) {
    this.obstacles.add(obstacle);
  }
  
  /**
   * Filtre les éléments d'une classe donnée
   * Lors de la prochaine itération, seuls les éléments de la classe donnée
   * seront retournés
   * @param className le nom de la classe
   */
  public void setFilter (String className) {
    this.filter = className;
  }

  public ArrayList<Robot> getRobots() {
    return robots;
  }

  public ArrayList<Obstacle> getObstacles() {
    return obstacles;
  }
  
}