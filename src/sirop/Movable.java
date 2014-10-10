/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

/**
 *
 * @author zhaoshuli
 */

public interface Movable {
  /** Changer la position **/ 
  boolean deplacer(Point2D vecteurDeplacement);
  /** Vérifier si la position correspond la contrainte**/
  boolean deplacementAutorise(Point2D vecteurDeplacement);
}
