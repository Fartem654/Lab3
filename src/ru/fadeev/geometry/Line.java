package ru.fadeev.geometry;

import ru.fadeev.geometry.PointDefault.Point;
import java.util.Objects;

public class Line implements Cloneable{

	private Point start;
	private Point end;

	//GET SET
	public void setStart(double x, double y) {
		if (this.start != null) {
			this.start.setX(x);
			this.start.setY(y);
		} else {
			this.start = new Point(x, y);
		}
	}

	public void setStart(Point start) {
		this.start = new Point(start);
	}

	public Point getStart() {
		return start;
	}

	public void setEnd(double x, double y) {
		if (this.end != null) {
			this.end.setX(x);
			this.end.setY(y);
		} else {
			this.end = new Point(x, y);
		}
	}

	public void setEnd(Point end) {
		this.end = new Point(end);
	}

	public Point getEnd() {
		return end;
	}

	//Constructors
	public Line(Point start, Point end) { //4.2
		setStart(start);
		setEnd(end);
	}

	public Line(double startX, double startY, double endX, double endY) { //4.2
		setStart(new Point(startX, startY));
		setEnd(new Point(endX, endY));
	}

	//Methods
	public int lineLength() {
		double length = 0;
		double lenX = end.getX() - start.getX();
		double lenY = end.getY() - start.getY();
		length = Math.sqrt(lenX * lenX + lenY * lenY);
		return (int) Math.round(length);
	}

	@Override
	public String toString() {
		return "Линия от " + start.toString() + " до " + end.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Line line = (Line) o;
		return start.getX() == line.start.getX() && start.getY() == line.start.getY() && end.getX()== line.end.getX() && end.getY() == line.end.getY();
	}

	@Override
	public int hashCode() {
		return Objects.hash(start, end);
	}

	//8.5
	@Override
	public Line clone() throws CloneNotSupportedException {
		return new Line(new Point(this.start), new Point(this.end));
	}
}
