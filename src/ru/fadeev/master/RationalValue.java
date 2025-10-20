package ru.fadeev.master;

public class RationalValue implements NumericValue {
	private final int numerator;
	private final int denominator;

	public RationalValue(int numerator, int denominator) {
		if (denominator == 0) {
			throw new IllegalArgumentException("Denominator cannot be zero");
		}
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public double toDouble() {
		return (double) numerator / denominator;
	}

}
