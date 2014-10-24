/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */

package sirop;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
  private PlateauJeu plateau;
  
  public ListeElementsJeu(PlateauJeu plateau) {
    this.plateau = plateau;
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
      out.writeUTF(elem.getClass().getSimpleName());
      elem.writeObject(out);
      out.writeChar('\n');
    }
  }

  public void readObject(ObjectInputStream in) throws IOException {
    while (true) {
      String cname = "";
      try {
        cname = getClass().getPackage().getName() + "." + in.readUTF();
      } catch(IOException ex) {
        return;
      }
      try {
        Class elemclass = Class.forName(cname);
        if (ElementJeu.class.isAssignableFrom(elemclass)){
          Class[] params = new Class[1];
          params[0] = PlateauJeu.class;
          Constructor constructor = elemclass.getDeclaredConstructor(params);
          ElementJeu elem = (ElementJeu) constructor.newInstance(this.plateau);
          elem.readObject(in);
          if (Robot.class.isAssignableFrom(elemclass)) {
            this.ajoutRobot((Robot) elem);
          } else if (Obstacle.class.isAssignableFrom(elemclass)) {
            this.ajoutObstacle((Obstacle) elem);
          } else {
            throw new InvalidClassException(
                    "Impossible de stocker un élément de classe "
                            + cname
                            + " dans ListeElementsJeu");
          }
        } else {
          throw new InvalidClassException(cname+" is not a subclass of ElementJeu");
        }
      } catch (ClassNotFoundException | InstantiationException |
              IllegalAccessException | InvalidClassException | SecurityException |
              NoSuchMethodException | InvocationTargetException ex) {
        System.err.println("Impossible de créer un élément de la classe "+cname);
        throw new IOException("Invalid file: " + ex);
      }
    }
  }
  
}
