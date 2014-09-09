import org.junit.Test;
import org.junit.Assert.*;

public class TestPoint2D {
	@Test
	public final void testCreation() {
		Point2D p = new Point2D(5,10);
		org.junit.Assert.assertEquals("Abscisse", p.getX(), 5);
		org.junit.Assert.assertEquals("Ordonnée", p.getY(), 10);
		Point2D p2 = new Point2D(p);
		org.junit.Assert.assertEquals("Abscisse de la copie", p.getX(), 5);
		org.junit.Assert.assertEquals("Ordonnée de la copie", p.getY(), 10);
	}

	@Test
	public final void testSetters() {
		Point2D p = new Point2D(0,0);
		p.setX(10);
		org.junit.Assert.assertEquals("setX", p.getX(), 10);
		p.setY(10);
		org.junit.Assert.assertEquals("setY", p.getY(), 10);
		p.setPosition(255, 254);
		org.junit.Assert.assertEquals("setX", p.getX(), 255);
		org.junit.Assert.assertEquals("setY", p.getY(), 254);

	}
}
