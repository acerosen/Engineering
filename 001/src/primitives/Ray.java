package primitives;

/**
 * Class contains ray in Euclidian space represented using base point p0 and
 * direction vector
 * 
 * @author eytan
 */

public class Ray {
	private Vector dir;
	private Point3D p0;

	// ***************** Constructors ********************** //
	/**
	 * Builds ray using Base point p0 and direction vector
	 * 
	 * @param p0  basepoint
	 * @param dir vector
	 * @return ray
	 */
	public Ray(Point3D p0, Vector dir) {
		this.p0 = p0;
		this.dir = dir.normalized();
	}

	// ***************** Getters/Setters ********************** //
	/**
	 * Gets base point p0
	 * @return p0 base point
	 */
	public Point3D getP0() {
		return p0;
	}

	/**
	 * Gets direction vector
	 * @return dir vector
	 */
	public Vector getDir() {
		return dir;
	}

	// ***************** Administration ******************** //
	/**
	 * Returns ray in string form
	 * @return String
	 */
	@Override
	public String toString() {
		return "[" + getP0() + getDir();
	}

}
