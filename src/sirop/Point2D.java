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
}
