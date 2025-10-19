package ru.fadeev.Calculator;
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import ru.fadeev.Main.NumericValue;

public class Calculator {

	public static double sum(NumericValue... values) {
		double totalSum = 0;
		for (NumericValue value : values) {
			totalSum += value.toDouble();
		}
		return totalSum;
	}

	//7.3
	public static double powString(String strX, String strY) {
		int x = parseInt(strX);
		int y = parseInt(strY);
		return pow(x, y);
	}

	public static void main(String[] args) { // 7.3   java src/ru/fadeev/Calculator/Calculator.java 2 2
		if (args.length < 2) {
			System.err.println("Использование: java Calculator <X> <Y>");
			return;
		}

		try {
			double result = powString(args[0], args[1]);
			System.out.println(result);
		} catch (NumberFormatException e) {
			System.err.println("Ошибка: оба аргумента должны быть целыми числами.");
		} catch (Exception e) {
			System.err.println("Ошибка при вычислении: " + e.getMessage());
		}
	}
}
