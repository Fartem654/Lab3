package ru.fadeev.geometry.AbstractPoint;

public abstract class PointProperty {

	protected String color;
	protected String creationTime;

	// Get Set

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getCreationTime() {
		return creationTime;
	}

	//Constructors
	public PointProperty() {
	}

	public PointProperty(String color, String creationTime) {
		this.color = color;
		this.creationTime = creationTime;
	}

	//Methods
	public abstract String showCoordinates();

	@Override
	public String toString() {
		String string = "";
		string = "Точка: " + showCoordinates();
		if (color != null) {
			string += ", цвет: " + color;
		}
		if (creationTime != null) {
			string += ", время создания: " + creationTime;
		}
		return string;
	}
}
