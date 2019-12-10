package primitives;

import java.lang.Math;

/**
 * Class contains point in Euclidian space represented using Cartesian
 * coordinates
 *
 * @author eytan
 */

public class Point3D {
	public static Point3D ZERO = new Point3D(0, 0, 0);

	private Coordinate _x;
	private Coordinate _y;
	private Coordinate _z;

	// ***************** Constructors ********************** //
	/**
	 * Creates copy of Point3D from Point3D
	 * 
	 * @param point to be copied
	 * @return copy of point
	 */
	Point3D(Point3D point) {
		_x = new Coordinate(point._x);
		_y = new Coordinate(point._y);
		_z = new Coordinate(point._z);
	}

	/**
	 * Builds Point3D using three coordinate type values
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @param z coordinate
	 * @return Point3D with x,y,z as values
	 */
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
		_z = new Coordinate(z);
	}

	/**
	 * Builds Point3D using the value of three coordinates
	 * 
	 * @param x coordinate value
	 * @param y coordinate value
	 * @param z coordinate value
	 * @return Point3D with x,y,z as values
	 */
	public Point3D(double x, double y, double z) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
		_z = new Coordinate(z);
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * Gets X value of point as coordinate type value
	 * 
	 * @return x coordinate
	 */
	public Coordinate getX() {
		return _x;
	}

	/**
	 * Gets Y value of point as coordinate type value
	 * 
	 * @return y coordinate
	 */
	public Coordinate getY() {
		return _y;
	}

	/**
	 * Gets Z value of point as coordinate type value
	 * 
	 * @return z coordinate
	 */
	public Coordinate getZ() {
		return _z;
	}

	// ***************** Operations ******************** //
	/**
	 * Builds vector on a Point3D, and returns the head of new vector
	 * 
	 * @param vector to be added to point
	 * @return head of new vector
	 */
	public Point3D add(Vector vec) {
		double x = _x.get() + vec.getHead()._x.get();
		double y = _y.get() + vec.getHead()._y.get();
		double z = _z.get() + vec.getHead()._z.get();
		return new Point3D(x, y, z);
	}

	/**
	 * Subtracts one point from another point, and returns the resulting vector
	 * 
	 * @param point that is subtracted from reference point
	 * @return Vector created using subtraction method
	 */
	public Vector subtract(Point3D point) {
		double x = _x.get() - point._x.get();
		double y = _y.get() - point._y.get();
		double z = _z.get() - point._z.get();
		return new Vector(x, y, z);
	}

	/**
	 * Calculates distance between two points, and returns the distance without the
	 * square root
	 * @param other point used to calculate distance
	 * @return double distance without square root
	 */
	public double squaredDistance(Point3D other) {
		if (this.equals(other))
			return 0;
		double a = (this.getX().get()) - (other.getX().get());
		double b = (this.getY().get()) - (other.getY().get());
		double c = (this.getZ().get()) - (other.getZ().get());
		double temp = (a * a) + (b * b) + (c * c);
		return temp;
	}

	/**
     * Calculates distance between two point, and returns distance
	 * @param other point used to calculate distance
	 * @return double distance
	 */
	public double distance(Point3D other) {
		return Math.sqrt(squaredDistance(other));
	}

	// ***************** Administration ******************** //
	/**
	 * Checks if two points are equal to one another.
	 * @param o, object which is compared to reference point
	 * @return equality
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Point3D))
			return false;
		Point3D other = (Point3D) o;
		return (_x.equals(other._x)) && (_y.equals(other._y)) && (_z.equals(other._z));

	}

	/**
	 * Returns point as string
	 * @return String
	 */
	@Override
	public String toString() {
		return "(" + _x + "," + _y + "," + _z + ")";
	}

}
