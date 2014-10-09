/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

/**
 *
 * @author zhaoshuli
 */

public interface Movable {
  //change the position 
  boolean deplacer(Point2D vecteurDeplacement);
  //return if it can change to the position
  boolean deplacementAutorise(Point2D vecteurDeplacement);
}
