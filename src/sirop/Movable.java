/*
 Ce projet est libre; sous les temes de la license LGPLv3
 */
package sirop;

/**
 *
 * @author zhaoshuli
 */
public interface Movable {
  boolean deplacer(Point2D vecteurDeplacement);
  boolean deplacementAutorise(Point2D vecteurDeplacement);
}
