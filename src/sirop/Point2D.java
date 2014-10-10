package sirop;

/**
 * Représente un point en deux dimensions
 */
public class Point2D {
	private int x;
	private int y;

	public Point2D (int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Copie un point existant
	 * @param point Le point à copier
	 */
	public Point2D (Point2D point) {
		if (point == null)
			throw new RuntimeException("invalid point passed as an argument to Point2D's constructor");
		this.x = point.x;
		this.y = point.y;
	}
	
	/**
	 * @return L'abscisse
	 */
	public int getX() {return this.x;}
	/**
	 * @return L'ordonnée
	 */
	public int getY() {return this.y;}

	/**
	 * @param x L'abscisse
	 */
	public void setX(int x) {this.x = x;}
	/**
	 * @param y L'ordonnée
	 */
	public void setY(int y) {this.y = y;}

	/**
	 * @param x L'abscisse
	 * @param y L'ordonnée
	 */
	public void setPosition(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	/**
	 * Affiche les coordonnées du point actuel sous la forme {x:0, y:0}
	 */
	public void printCoords() {
		System.out.format("{x:%d, y:%d}", this.x, this.y);
	}

	public boolean isEqualTo(Point2D point) {
		return (this.x == point.x && this.y == point.y);
        
        
                
                
                
	}

  /** Retourne un point dont les coordonnées sont la somme des coordonnées
   * actuelles et des coordonnées fournies
   */
  public Point2D plus(Point2D p) {
    Point2D np = new Point2D(this);
    np.deplacer(p);
    return np;
  }

  /** Déplace le point:
   * Ajoute les coordonnées de p aux cordonnées du point
   * @param p Le vecteur de déplacement
   */
  public void deplacer(Point2D p) {
    this.setX(this.getX() + p.getX());
    this.setY(this.getY() + p.getY());
  }
  /** Retourner true si les deux points sont identiques **/
  public boolean equals(Point2D p) {
    return p.getX() == this.getX() && p.getY() == this.getY();
  }
}
