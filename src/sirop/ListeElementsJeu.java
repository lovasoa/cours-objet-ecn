/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */

package sirop;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olojkine
 */
public class ListeElementsJeu implements Iterable<ElementJeu>, Serializable{

  private ArrayList<Robot> robots;
  private ArrayList<Obstacle> obstacles;
  private ArrayList<ArrayList<? extends ElementJeu>> allLists;
  
  public ListeElementsJeu() {
    this.robots = new ArrayList<>();
    this.obstacles = new ArrayList<>();
    this.allLists = new ArrayList<>();
    this.allLists.add(this.robots);
    this.allLists.add(this.obstacles);
  }
  
  @Override
  public Iterator<ElementJeu> iterator() {
    return (new IterableOfIterables<ElementJeu>(this.allLists)).iterator();
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
  
  public Iterable<ElementJeu> filter(Class<? extends ElementJeu> filterClass) {
    return (new FilteredIterable<ElementJeu>(this, filterClass));
  }

  int size() {
    int sum=0;
    for (ArrayList<? extends ElementJeu> liste: this.allLists) {
      sum += liste.size();
    }
    return sum;
  }
  
  public void writeObject(ObjectOutputStream out) throws IOException {
    for (ElementJeu elem : this) {
      out.writeUTF(elem.getClass().getName());
      elem.writeObject(out);
      out.writeChar('\n');
    }
  }

  public void readObject(ObjectInputStream in) throws IOException {
    while (true) {
      String cname = in.readUTF();
      try {
        Class elemclass = Class.forName(cname);
        if (ElementJeu.class.isAssignableFrom(elemclass)){
          ElementJeu elem = (ElementJeu)elemclass.newInstance();
        } else {
          throw new InvalidClassException(cname+" is not a subclass of ElementJeu");
        }
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvalidClassException ex) {
        System.err.println("Impossible de créer un élément de la classe "+cname);
      }
    }
  }
  
}
