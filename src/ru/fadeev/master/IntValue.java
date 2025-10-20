package ru.fadeev.master;

public class IntValue implements NumericValue {
	private final int value;

	public IntValue(int value) {
		this.value = value;
	}

	@Override
	public double toDouble() {
		return value;
	}
}
