package primitives;

import java.lang.Math;

/**
 * Class contains vector in Euclidian space represented using Cartesian
 * coordinates
 * 
 * @author eytan
 */

public class Vector {
	private Point3D _head;

	// ***************** Constructors ********************** //
	/**
	 * Creates copy of vector
	 * 
	 * @param vector to be copied
	 * @return copy of vector
	 */
	Vector(Vector vector) {
		_head = new Point3D(vector._head);
	}

	/**
	 * Builds Vector using three coordinate type values
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 * @param z coordinate
	 * @return Vector with x,y,z as values
	 */
	public Vector(Coordinate x, Coordinate y, Coordinate z) {
		_head = new Point3D(x, y, z);
		if (Point3D.ZERO.equals(_head))
			throw new IllegalArgumentException("Zero vector");
	}

	/**
	 * Builds Vector using values of three coordinates
	 * 
	 * @param x coordinate value
	 * @param y coordinate value
	 * @param z coordinate value
	 * @return Vector with x,y,z as values
	 */
	public Vector(double x, double y, double z) {
		_head = new Point3D(x, y, z);
		if (Point3D.ZERO.equals(_head))
			throw new IllegalArgumentException("Zero vector");
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * Gets head of vector
	 * 
	 * @return _head, Point3D at head of vector
	 */
	public Point3D getHead() {
		return _head;
	}

	// ***************** Operations ******************** //
	/**
	 * Calculates length of vector before square root
	 * 
	 * @return length before square root
	 */
	public double squaredLength() {
		return (_head.getX().get() * _head.getX().get()) + (_head.getY().get() * _head.getY().get())
				+ (_head.getZ().get() * _head.getZ().get());
	}

	/**
	 * Calculates length of vector
	 * 
	 * @return length
	 */
	public double length() {
		return Math.sqrt(squaredLength());
	}

	/**
	 * Creates vector whose values are the sums of two other vectors
	 * 
	 * @param vec which is added to reference vector
	 * @return Vector which contains sum values
	 */
	public Vector add(Vector vec) {
		double x = _head.getX().get() + vec._head.getX().get();
		double y = _head.getY().get() + vec._head.getY().get();
		double z = _head.getZ().get() + vec._head.getZ().get();
		return new Vector(x, y, z);
	}

	/**
	 * Creates vector whose values are the difference of two other vectors
	 * 
	 * @param vec which is subtracted from reference vector
	 * @return Vector which contains difference values
	 */
	public Vector subtract(Vector vec) {
		return new Vector((_head.getX().subtract(vec._head.getX())), (_head.getY().subtract(vec._head.getY())),
				(_head.getZ().subtract(vec._head.getZ())));
	}

	/**
	 * Creates vector whose values have been multiplied (scaled) by a scalar value
	 * 
	 * @param num by which the vector is multiplied
	 * @return Vector which contains scaled values
	 */
	public Vector scale(double num) {
		return new Vector((_head.getX().scale(num)), (_head.getY().scale(num)), (_head.getZ().scale(num)));
	}

	/**
	 * Calculates dot product of two vectors
	 * 
	 * @param vec used to calculate dot product
	 * @return double, result
	 */
	public double dot(Vector vec) {
		double x = _head.getX().get() * vec._head.getX().get();
		double y = _head.getY().get() * vec._head.getY().get();
		double z = _head.getZ().get() * vec._head.getZ().get();
		return x + y + z;
	}

	/**
	 * Creates vector that is the cross product of two vectors
	 * 
	 * @param vec used to create cross product vector
	 * @return Vector cross product
	 */
	public Vector cross(Vector vec) {
		Double x = (_head.getY().get()) * (vec._head.getZ().get()) - (_head.getZ().get()) * (vec._head.getY().get());
		Double y = (_head.getZ().get()) * (vec._head.getX().get()) - (_head.getX().get()) * (vec._head.getZ().get());
		Double z = (_head.getX().get()) * (vec._head.getY().get()) - (_head.getY().get()) * (vec._head.getX().get());
		return new Vector(x, y, z);
	}

	/**
	 * Creates vector that is normalized vector of reference vector
	 * 
	 * @return Vector that's normalized
	 */
	public Vector normalized() {
		return (scale(1 / length()));
	}

	/**
	 * Normalizes reference vector
	 * 
	 * @return Vector that's normalized
	 */
	public void normalize() {
		this.normalized();
	}
	// ***************** Administration ******************** //
	/**
	 * Checks if two vectors are equal
	 * 
	 * @param vec to be checked if equal to reference vector
	 * @return equality
	 */
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof Vector))
			return false;
		Vector vec = (Vector) o;
		return _head.equals(vec._head);
	}

	/**
	 * Returns vector as string
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		return "->" + _head;
	}

}
