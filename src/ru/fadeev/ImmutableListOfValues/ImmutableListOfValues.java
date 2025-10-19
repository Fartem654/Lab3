package ru.fadeev.ImmutableListOfValues;

import java.util.Arrays;

public class ImmutableListOfValues {
	private final int[] list;

  //Constructors
	public ImmutableListOfValues(int... values) {
		this.list = (values == null) ? new int[0] : values.clone();
	}

	public ImmutableListOfValues(ImmutableListOfValues other) {
		this.list = other.list.clone();
	}

	public void setValue(int index, int newValue) {
		if (index < 0 || index >= list.length) {
			throw new IndexOutOfBoundsException("Индекс " + index + " не попадает в диапазон массива: 0,"+list.length);
		}
		list[index] = newValue;
	}

	public int getValue(int index) {
		if (index < 0 || index >= list.length) {
			throw new IndexOutOfBoundsException("Индекс " + index + " не попадает в диапазон массива: 0,"+list.length);
		}
		return list[index];
	}

	public boolean isEmpty() {
		return list.length == 0;
	}

	public int size() {
		return list.length;
	}

	public int[] getList() {
		return list.clone();
	}

	@Override
	public String toString() {
		return Arrays.toString(list);
	}
}