package primitives;

import java.lang.Math;

/**
 * 
 * @author eytan
 *
 */

public class Point3D {
	public static Point3D ZERO = new Point3D(0, 0, 0);

	private Coordinate _x;
	private Coordinate _y;
	private Coordinate _z;

	// ***************** Constructors ********************** //
	/**
	 * @name Point3D
	 * @param point
	 */
	Point3D(Point3D point) {
		_x = new Coordinate(point._x);
		_y = new Coordinate(point._y);
		_z = new Coordinate(point._z);
	}

	/**
	 * @name Point3D
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Coordinate x, Coordinate y, Coordinate z) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
		_z = new Coordinate(z);
	}

	/**
	 * Point3D
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x, double y, double z) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
		_z = new Coordinate(z);
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * @name getX
	 * @return Coordinate
	 */
	public Coordinate getX() {
		return _x;
	}

	/**
	 * @name getY
	 * @return Coordinate
	 */
	public Coordinate getY() {
		return _y;
	}

	/**
	 * @name getZ
	 * @return Coordinate
	 */
	public Coordinate getZ() {
		return _z;
	}

	// ***************** Operations ******************** //
	public Point3D add(Vector vec) {
		double x = _x.get() + vec.getHead()._x.get();
		double y = _y.get() + vec.getHead()._y.get();
		double z = _z.get() + vec.getHead()._z.get();
		return new Point3D(x, y, z);
	}

	/**
	 * @name subtract
	 * @param point
	 * @return: Vector
	 * @description Subtracts Point from This to create vector
	 */
	public Vector subtract(Point3D point) {
		double x = _x.get() - point._x.get();
		double y = _y.get() - point._y.get();
		double z = _z.get() - point._z.get();
		return new Vector(x, y, z);
	}

	/**
	 * @name getSquaredDistance
	 * @param _point
	 * @return double
	 * @description Gets distance (without sqrt) between 2 points
	 */
	public double distance2(Point3D other) {
		if (this.equals(other))
			return 0;
		double a = (this.getX().get()) - (other.getX().get());
		double b = (this.getY().get()) - (other.getY().get());
		double c = (this.getZ().get()) - (other.getZ().get());
		double temp = (a * a) + (b * b) + (c * c);
		return temp;
	}

	/**
	 * @name getDistance
	 * @param _point
	 * @return double
	 * @description returns distance with sqrt
	 */
	public double distance(Point3D _point) {
		return Math.sqrt(distance2(_point));
	}

	// ***************** Administration ******************** //
	/**
	 * @name equals
	 * @param o
	 * @return boolean
	 * @description checks if two points are equal
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Point3D ))
			return false;
		Point3D other = (Point3D) o;
		return (_x.equals(other._x)) && (_y.equals(other._y)) && (_z.equals(other._z));

	}

	/**
	 * @name toString
	 * @return String
	 */
	@Override
	public String toString() {
		return "(" + _x + "," + _y + "," + _z + ")";
	}

}
