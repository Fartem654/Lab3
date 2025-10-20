package ru.fadeev.master;

public class FractionalValue implements NumericValue {
	private final double value;

	public FractionalValue(double value) {
		this.value = value;
	}

	@Override
	public double toDouble() {
		return value;
	}
}
