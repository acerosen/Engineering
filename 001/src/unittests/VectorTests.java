package unittests;

import primitives.Vector;
import org.junit.*;

import junit.framework.TestCase;

public class VectorTests extends TestCase {

	@Test
	public void testSquaredLength() {
		Vector vec1 = new Vector(2, 2, 2);
		double result = 12;
		assertEquals(result, vec1.squaredLength());
	}

	@Test
	public void testLength() {
		Vector vec1 = new Vector(2, 2, 2);
		double result = 3.4641016151377544;
		assertEquals(result, vec1.length());
	}

	@Test
	public void testAdd() {
		Vector vec1 = new Vector(1, 2, 3);
		Vector vec2 = new Vector(5, 5, 5);
		Vector result = new Vector(6, 7, 8);
		assertEquals(result, vec1.add(vec2));
	}

	@Test
	public void testSubtract() {
		Vector vec1 = new Vector(1, 2, 3);
		Vector vec2 = new Vector(5, 5, 5);
		Vector result = new Vector(4, 3, 2);
		assertEquals(result, vec2.subtract(vec1));
	}

	@Test
	public void testScale() {
		Vector vec1 = new Vector(2, 2, 2);
		double scalar = 7;
		Vector result = new Vector(14, 14, 14);
		assertEquals(result, vec1.scale(scalar));
	}

	@Test
	public void testDot() {
		Vector vec1 = new Vector(3, 3, 3);
		Vector vec2 = new Vector(6, 6, 6);
		double result = 54;
		assertEquals(result, vec1.dot(vec2));
	}

	@Test
	public void testCross() {
		Vector vec1 = new Vector(1, 2, 3);
		Vector vec2 = new Vector(4, 5, 6);
		Vector result = new Vector(-3, 6, -3);
		assertEquals(result, vec1.cross(vec2));
	}

	@Test
	public void testNormalized() {
		Vector vec1 = new Vector(1, 0, 0);
		Vector vec2 = vec1.normalized();
		Vector result = new Vector(1, 0, 0);
		assertEquals(result, vec2);
	}

	@Test
	public void testNormalize() {
		Vector vec1 = new Vector(1, 0, 0);
		vec1.normalize();
		Vector result = new Vector(1, 0, 0);
		assertEquals(result, vec1);
	}

	@Test
	public void testEquals() {
		Vector vec1 = new Vector(55, 6, 0.2);
		Vector vec2 = new Vector(55, 6, 0.2);
		Vector vec3 = new Vector(55, 6, 0);
		assertTrue(vec1.equals(vec2));
		assertFalse(vec1.equals(vec3));
	}

}
