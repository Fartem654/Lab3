package ru.fadeev.geometry.PointDefault;

public class Point3D extends Point {

	private double z;

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public Point3D() {
		super();
		setZ(0);
	}

	public Point3D(double x, double y, double z) {
		super(x, y);
		setZ(z);
	}

	public Point3D(Point3D point) {
		super(point);
		setZ(point.getZ());
	}

	@Override
	public String toString() {
		return '{' + Double.toString(super.getX()) + ';' + Double.toString(super.getY()) + ';' + z + '}';
	}
}
