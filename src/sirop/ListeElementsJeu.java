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
  private ArrayList<ArrayList<ElementJeu>> all;
  
  public ListeElementsJeu() {
    this.robots = new ArrayList<>();
    this.obstacles = new ArrayList<>();
    this.all = new ArrayList<>();
    this.all.add((ArrayList<ElementJeu>)(ArrayList<?>)this.robots);
    this.all.add((ArrayList<ElementJeu>)(ArrayList<?>)this.obstacles);
  }
  
  @Override
  public Iterator<ElementJeu> iterator() {
    Iterable<Iterable<ElementJeu>> els;
    els = (Iterable<Iterable<ElementJeu>>)(Iterable<?>)this.all;
    return (new IterableOfIterables<>(els)).iterator();
  }
  
  public void ajoutRobot(Robot robot) {
    this.robots.add(robot);
  }
  
  public void ajoutObstacle(Obstacle obstacle) {
    this.obstacles.add(obstacle);
  }
  
  public ArrayList<Robot> getRobots() {
    return robots;
  }

  public ArrayList<Obstacle> getObstacles() {
    return obstacles;
  }
  
}