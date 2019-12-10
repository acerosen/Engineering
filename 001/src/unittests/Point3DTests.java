package unittests;

import static org.junit.Assert.*;
import primitives.*;
import org.junit.Test;

public class Point3DTests {

	@Test
	public void testAdd() {
		Point3D p1 = new Point3D(1, 1, 1);
		Vector vec = new Vector(3, 3, 3);
		Point3D result = new Point3D(4, 4, 4);
		assertEquals(result, p1.add(vec));
	}

	@Test
	public void testSubtract() {
		Point3D p1 = new Point3D(4, 4, 4);
		Point3D p2 = new Point3D(1, 1, 1);
		Vector result = new Vector(3, 3, 3);
		assertEquals(result, p1.subtract(p2));
	}

	@Test
	public void testSquaredDistance() {
		Point3D p1 = new Point3D(1, 1, 1);
		Point3D p2 = new Point3D(2, 2, 2);
		double result = 3;
		assertTrue(result == p1.squaredDistance(p2));
	}

	@Test
	public void testDistance() {
		Point3D p1 = new Point3D(10, 10, 10);
		Point3D p2 = new Point3D(10, 10, 10);
		assertTrue(0 == p2.distance(p1));
	}

	@Test
	public void testEqualsObject() {
		Point3D p1 = new Point3D(2, 2, 2);
		Point3D p2 = new Point3D(2, 2, 2);
		Point3D p3 = new Point3D(1, 1, 1);
		assertTrue(p1.equals(p2));
		assertFalse(p1.equals(p3));
	}

}
