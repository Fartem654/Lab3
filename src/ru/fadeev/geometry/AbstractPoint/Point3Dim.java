package ru.fadeev.geometry.AbstractPoint;

public class Point3Dim extends PointProperty {
	private int x;
	private int y;
	private int z;


	// Get Set
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	//Constructors
	public Point3Dim() {
		setX(0);
		setY(0);
		setZ(0);
	}

	public Point3Dim(String color, String creationTime) {
		setX(0);
		setY(0);
		setZ(0);
		setColor(color);
		setCreationTime(creationTime);
	}

	public Point3Dim(int x, int y, int z) {
		setX(x);
		setY(y);
		setZ(z);
	}

	public Point3Dim(int x, int y, int z, String color, String creationTime) {
		setX(x);
		setY(y);
		setZ(z);
		setColor(color);
		setCreationTime(creationTime);
	}

	public Point3Dim(Point3Dim point) {
		setX(point.x);
		setY(point.y);
		setZ(point.z);
	}

	public Point3Dim(Point3Dim point, String color, String creationTime) {
		setX(point.x);
		setY(point.y);
		setZ(point.z);
		setColor(color);
		setCreationTime(creationTime);
	}

	//Methods
	@Override
	public String showCoordinates() {
		return "{" + x + ';' + y + ';' + z + '}';
	}
}
